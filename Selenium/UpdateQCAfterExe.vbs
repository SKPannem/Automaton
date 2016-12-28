Dim strLocation
Dim strExcelPath, strTestResulXmlPath
Dim strScreenShotPath
Dim ConnectionClass
Dim QCfso : Set QCfso = CreateObject("Scripting.FileSystemObject")
Dim QCobjFile
Dim strTextData
Dim setUpDetailMap : Set setUpDetailMap = CreateObject("Scripting.Dictionary")
Dim testCaseExeStatusMap : Set testCaseExeStatusMap = CreateObject("Scripting.Dictionary")
Dim testCaseIDMap : Set testCaseIDMap = CreateObject("Scripting.Dictionary")
Dim testProps : Set testProps = CreateObject( "Scripting.Dictionary" )
Dim retryMap : Set retryMap = CreateObject( "Scripting.Dictionary" )
Dim iMappingDataColumn
Dim strExeStatus
Dim v,itry
Dim retryCount

strLocation = CreateObject("Scripting.FileSystemObject").GetParentFolderName(WScript.ScriptFullName)
strExcelPath = strLocation & "\resources\QCData\QCIntegration.xls"

'Msgbox strExcelPath
Call GetSetUpDatafromExcel()
'Msgbox Err.Description
If connectToALM() Then
	Call ReadPropertiesFile()
	
	retryCount = Cint(testProps("testProps"))
	
	'read all archive folder in case of retry from backwards	
	For v = retryCount+1 to 0 Step-1
		itry = v + 1
		strTestResulXmlPath = strLocation & "\Test\build\test-output\archive" & CStr(itry) & "\testng-results.xml"
		strTestResulTempXmlPath = strLocation & "\Test\build\test-output\archive" & CStr(itry) & "\testng-results_temp.xml"
		'remove all content that can cause issue during parsing - testng-results.xml
		Call StripTextBtnTag(strTestResulXmlPath,strTestResulTempXmlPath,"reporter-output","dummy")
		
		'msgbox strTestResulXmlPath
		Call ReadExeResultXmlData(strTestResulTempXmlPath,itry)
	Next
	
	Call GetBrowserDetails()
	Call GetMappingDatafromExcel(iMappingDataColumn)
	arrTestCases=testCaseExeStatusMap.Keys
	iKeys=Ubound(arrTestCases)
	'Msgbox arrTestCases(0)
	'Msgbox "Hi:" & testCaseIDMap(arrTestCases(0))
	Dim iTestSet1,iTestCaseID1
	Dim objTestSet
	'Dim arrValues()
	For v = 0 To iKeys
		If arrTestCases(v) <> "setUp" And arrTestCases(v) <> "copyToTempFldr" then
			strKey = arrTestCases(v)
			strExeStatus = testCaseExeStatusMap(strKey)
			strTestSetTestCase = testCaseIDMap(strKey)
			'If mapping not availale in mapping sheet skip update
			If strTestSetTestCase <> "" then
				'Msgbox strTestSetTestCase
				arrValues = Split(strTestSetTestCase,"#")
				iTestSet1 = arrValues(0)
				iTestCaseID1 = arrValues(1)
				If IsExecuteTestCaseID(strKey) Then
					Set objTestSet = GetTestSet(iTestSet1)
					Set objRunInst = UpdateQC(objTestSet,iTestCaseID1)
					Set otaAttachmentFactory = objRunInst.Attachments
					'Attach Real_Time_Report for the test case
					Set attachList = otaAttachmentFactory.AddItem(Null)
					attachList.FileName = strLocation & "\realtimereportbkup\" & strKey & ".html"
					attachList.Type = 1
					attachList.Post
					attachList.Refresh
					Set attachList = nothing
					'Attach error screen shot
					'file:///D:/Workspace/eSysco/Test/build/test-output/archive1/com.tests.OrderEntrySubmit.CreateOrderFromQuickEntry.ogg
					If UCase(strExeStatus) = "FAIL" Then
						strReportType = testProps("reportType")
						if strReportType = "allure" Then
							strScreenShotPath = strLocation & "\Test\build\test-output\archive" & CStr(retryMap(strKey)) & "\screenshots\" & strKey & "_Screenshot.png"
						Elseif strReportType = "reportng" Then
							strScreenShotPath = strLocation & "\Test\build\test-output\archive" & CStr(retryMap(strKey)) & "\html\screenshots\" & strKey & "_Screenshot.png"
						End if
						Set attachList = otaAttachmentFactory.AddItem(Null)
						attachList.FileName = strScreenShotPath
						attachList.Type = 1
						attachList.Post
						attachList.Refresh
						Set attachList = nothing
					End if
				End if
				strTestSetTestCase = ""
				strExeStatus = ""
			End if
		End If
	Next
	If Err.Number <> 0 then
		'WScript.Echo Err.Description
	Else
		'WScript.Echo "QC Update Completed !!!"
	end if
End if

Public Function GetSetUpDatafromExcel()
	Dim objExcel : Set objExcel = CreateObject("Excel.Application")
	Dim objWorkbook : Set objWorkbook = objExcel.workbooks.Open(strExcelPath)

	Set xlSheet = objWorkbook.Worksheets(1)
	xlSheet.Activate
	iRow = 1 'First row with data
	iCol = 2 'First column with data
	strParamName= trim(objExcel.Cells(iRow, 1).Value)

	Do While strParamName <> ""				
		strParamVal =trim(objExcel.Cells(iRow, iCol).Value)
		'MsgBox strParamName & ":" & strParamVal
		setUpDetailMap.item(strParamName) = strParamVal	
		iRow =iRow +1
		strParamName= trim(objExcel.Cells(iRow, 1).Value)
	Loop

	objWorkbook.Close
	Set objWorkbook = Nothing
	Set objExcel = Nothing
End Function

Public Function GetMappingDatafromExcel(ByVal strColumn)
	Dim objExcel : Set objExcel = CreateObject("Excel.Application")
	Dim objWorkbook : Set objWorkbook = objExcel.workbooks.Open(strExcelPath)
	Dim iTestSet,iTestCaseID,strTestCaseName
	
	Set xlSheet = objWorkbook.Worksheets(2)
	xlSheet.Activate
	iRow = 2 'First row with data
	iCol = 2 'First column with data
	strTestCaseName= trim(objExcel.Cells(iRow, 1).Value)
	iTestCaseID = trim(objExcel.Cells(iRow, 2).Value)
	iTestSet = trim(objExcel.Cells(iRow, Cint(strColumn)).Value)
	Do While strTestCaseName <> ""				
		strParamVal =trim(objExcel.Cells(iRow, iCol).Value)
		'MsgBox strTestCaseName&"-->"&iTestSet&"#"&iTestCaseID
		testCaseIDMap(strTestCaseName) = iTestSet&"#"&iTestCaseID
		iRow =iRow +1
		strTestCaseName= trim(objExcel.Cells(iRow, 1).Value)
		iTestCaseID = trim(objExcel.Cells(iRow, 2).Value)
		iTestSet = trim(objExcel.Cells(iRow, Cint(strColumn)).Value)
	Loop

	objWorkbook.Close
	Set objWorkbook = Nothing
	Set objExcel = Nothing
End Function

Public Function GetBrowserDetails()
	Dim strBrowser,strVersion
	
	strBrowser = testProps("test.browser")
	Select Case strBrowser
		Case "*firefox"
			iMappingDataColumn = 3
			'GetBrowserDetails = "Firefox"
		Case "*iexplore"
			strVersion = testProps("test.browser.version")
			Select Case strVersion
				Case "8"
					iMappingDataColumn = 5
				Case "9"
					iMappingDataColumn = 6
				Case "10"
					iMappingDataColumn = 7
				Case "11"
					iMappingDataColumn = 8
			End Select
			'GetBrowserDetails = "IE"&strVersion			
		Case "*chrome"
			iMappingDataColumn = 4
			'GetBrowserDetails = "Chrome"			
	End Select
End Function

Public Function ReadPropertiesFile()
	Dim oFS : Set oFS = CreateObject( "Scripting.FileSystemObject" )
	Dim sPFSpec : sPFSpec = strLocation & "\test.properties"
	
	Dim oTS : Set oTS = oFS.OpenTextFile( sPFSpec )
	Dim sSect : sSect = ""
	Do Until oTS.AtEndOfStream
		Dim sLine : sLine = Trim( oTS.ReadLine )
		If "" <> sLine Then
			If "#" = Left( sLine, 1 ) Then
				'Skip	
			Else
				Dim aParts : aParts = Split( sLine, "=" )
				testProps( Trim( aParts( 0 ) ) ) = Trim( aParts( 1 ) )						
			End If
		End If
	Loop
	oTS.Close

	'Dim sKey
	'For Each sKey In testProps
	'	WScript.Echo sKey, "=>", testProps( sKey )
	'Next

End function

Public Function ReadExeResultXmlData(ByVal strTestResulXmlPath,ByVal itry)
	Dim xmlDoc : Set xmlDoc =  CreateObject("Microsoft.XMLDOM")
	xmlDoc.Async = False
	xmlDoc.Load(strTestResulXmlPath)		
	
	Set colNodes=xmlDoc.selectNodes("//testng-results/suite/test/class/test-method")

	For Each objNode in colNodes
	
		If testCaseExeStatusMap.exists(objNode.Attributes.getNamedItem("name").Text) = false then
			retryMap(objNode.Attributes.getNamedItem("name").Text) = itry
			testCaseExeStatusMap(objNode.Attributes.getNamedItem("name").Text) = objNode.Attributes.getNamedItem("status").Text			
		End if
	Next
End Function

Public Function connectToALM()
	On Error Resume Next
	Call CreateQCErrorLog()
	Set ConnectionClass = CreateObject("TDApiOle80.TDConnection")
	'msgbox setUpDetailMap("URL")
	ConnectionClass.InitConnectionEx setUpDetailMap("URL")'"http://ms240hpqcwb01:8080/qcbin"
	ConnectionClass.Login setUpDetailMap("UserName"),setUpDetailMap("Password")'"ks5435","Sysco111"

	'Connecting to the required project and domain
	ConnectionClass.Connect setUpDetailMap("Domain"),setUpDetailMap("Project")'"LEGACY","Esysco"

	'ConnectionClass.ConnectProjectEx("LEGACY","Esysco","ks5435","Sysco111")
	
	
	If Err.Number <> 0 then
		strTextData = "Unable to connect to Quality Centre. Error : " & Err.Description & vbLf
		QCobjFile.Write strTextData
		connectToALM = False
	Else
		strTextData = "Connect to Quality Centre as user : " & setUpDetailMap("UserName") & vbLf
		QCobjFile.Write strTextData
		connectToALM = True
	end if
End Function

Public Function CreateQCErrorLog()
	Dim strTextFilePath
	strTextFilePath = strLocation & "\QCErrorLog.txt"
    If QCfso.FileExists(strTextFilePath) Then
	   QCfso.DeleteFile(strTextFilePath)
    end if
	Set QCobjFile = QCfso.CreateTextFile(strTextFilePath,True)

End function

Public Function GetTestSet(ByVal strTSID)
	Dim oTestSetFolder, otestSetFact, otestFilter, otestList, oTestSet
 
	'Select the test set with the specific
	Set otestSetFact = ConnectionClass.TestSetFactory
	Set otestFilter = otestSetFact.Filter
	otestFilter.Filter("CY_CYCLE_ID") = strTSID
	Set otestList = otestSetFact.NewList(otestFilter.Text)

	if otestList.count = 0 then
		strTextData = "Unable to find test set with ID : " & strTSID & vbLf'& " in location : " & strTSPath
		QCobjFile.Write strTextData
		Set GetTestSet = Nothing
	Else
		strTextData = "Located the test set : " & strTSID & vbLf
		QCobjFile.Write strTextData
		
		Set oTestSet = otestList.Item(1)
		Set GetTestSet = oTestSet
	End if
	Set oTestSetFolder = Nothing
	Set otestSetFact = Nothing
	Set otestFilter = Nothing
	Set otestList = Nothing
	Set oTestSet = Nothing
End Function

Public Function UpdateQC(ByVal objectTestSet, ByVal iTCaseId)
	Dim objTestSetInstance, objRunInstance

	Set objTestSetInstance = GetTestCaseInTestSet(objectTestSet, iTCaseId)
		'update previous testcase 
	If Not objTestSetInstance Is Nothing Then
		strRunName = "SeleRun_" & Month(Now) & "-" & Day(Now) &"_"&  Hour(Now) & "-" & Minute(Now) & "-" & Second(Now)		

		Set UpdateQC = CreateRunInstance(objTestSetInstance, strRunName, strExeStatus)
		
	End If
	
	'strExeStatus = ""

End Function

Public Function IsExecuteTestCaseID (ByVal testCaseName) 	
	IsExecuteTestCaseID = (testCaseExeStatusMap ((testCaseName)) <> "") 	
 End Function
 
Public Function GetTestCaseInTestSet(ByVal oTestSet, ByVal iTestCaseId)
	Dim oTestInstanceF, oFilter, olst, oTest
	'Select the test set instance with the test case id 	
	Set oTestInstanceF = oTestSet.TSTestFactory
	Set oFilter = oTestInstanceF.Filter
	oFilter.Filter("TC_TEST_ID") =  iTestCaseId    
	Set olst = oTestInstanceF.NewList(oFilter.Text)
	
	if olst.count = 0 then
		strTextData = "Unable to find test case with id : " & iTestCaseId & vbLf
		QCobjFile.Write strTextData
		Set GetTestCaseInTestSet = Nothing
	Else
		strTextData = "Located test case with id : " & iTestCaseId & vbLf
		QCobjFile.Write strTextData
		Set oTest = olst.Item(1)
		Set GetTestCaseInTestSet = oTest
	End if
	Set oTestInstanceF = Nothing
	Set oFilter = Nothing
	Set olst = Nothing
	Set oTest = Nothing
End Function

 Public Function CreateRunInstance(ByVal objTest, ByVal strRunName, ByVal strStatus)
	Dim oRunInstance, oRun
	'Creating a Run 
	Set oRunInstance = objTest.RunFactory 
	Set oRun=oRunInstance.AddItem(Trim(strRunName))'Run Name 
	 'Msgbox strStatus
	 Select Case strStatus
		Case "PASS"
			strStatus = "Passed"
		Case "FAIL"
			strStatus = "Failed"
	 End Select
	oRun.Status = strStatus '"Failed"'Run Status 
	oRun.Post    
	oRun.Refresh 

	Set CreateRunInstance = oRun
	Set oRunInstance = Nothing
	Set oRun =Nothing
End function

 Public Function StripTextBtnTag(ByVal strSourceFile, ByVal strDestFile, ByVal strTag, ByVal strNewText)
	Const ForReading = 1
	Const ForWriting = 2

	Set objFSO = CreateObject("Scripting.FileSystemObject")
	Set objFile = objFSO.OpenTextFile(strSourceFile, ForReading)

	strText = objFile.ReadAll
	objFile.Close

	'Create a regular expression object
	Set objRegExp = New RegExp
	objRegExp.Global = True
	objRegExp.IgnoreCase = True
	objRegExp.MultiLine = True
	objRegExp.Pattern = "<" & strTag & ">[\s\S]*?<\/" & strTag & ">"

	'Get the matches
	Set colMatches = objRegExp.Execute(strText)

	'Do the replace
	For Each objMatch In colMatches

		strReplacedText = objRegExp.Replace(strText, "<" & strTag & ">" & strNewText & "</" & strTag & ">")
	Next

	If objFSO.FileExists(strDestFile)  then
		objFSO.DeleteFile strDestFile
	End If 

	Set oTxtFile = objFSO.CreateTextFile(strDestFile)  
	oTxtFile.Close
	Set objFile = objFSO.OpenTextFile(strDestFile, ForWriting)
	objFile.Write strReplacedText
	objFile.Close
End function