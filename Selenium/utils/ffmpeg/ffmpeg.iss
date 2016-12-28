; -- Example1.iss --
; Demonstrates copying 3 files and creating an icon.

; SEE THE DOCUMENTATION FOR DETAILS ON CREATING .ISS SCRIPT FILES!

[Setup]
AppName=ffmpeg
AppId=ffmpeg
AppVerName=ffmpeg
DefaultDirName={pf}\ffmpeg
DefaultGroupName=ffmpeg

SourceDir=c:/almar/projects/appsBin/ffmpeg
OutputDir=c:/almar/projects/appsBin
OutputBaseFilename = ffmpeg-win32-setup

ChangesEnvironment = yes
DisableProgramGroupPage = yes
Compression=lzma
SolidCompression=yes


[Files]
Source: "*.*"; DestDir: "{app}";

; the code below is to append to the path and remove on uninstalling
; to put off, comment the two functions at the end
[Code]
function Replace(Dest, SubStr, Str: string): string;
var
  Position: Integer;
  Ok: Integer;
begin
  Ok := 1;
  while Ok > 0 do
  begin
    Position:=Pos(SubStr, Dest);
    if Position > 0 then
    begin
      Delete(Dest, Position, Length(SubStr));
      Insert(Str, Dest, Position);
    end else
      Ok := 0;
  end
  Result:=Dest;
end;

procedure AppendToPath();
var
  V: string;
  Str: string;
begin
  RegQueryStringValue(HKLM, 'SYSTEM\CurrentControlSet\Control\Session Manager\Environment', 'Path', V)
  Str := ExpandConstant('{app}');
  V := Replace(V, Str, '');
  V := V + ';' + Str;
  V := Replace(V,';;',';');
  RegWriteStringValue(HKLM, 'SYSTEM\CurrentControlSet\Control\Session Manager\Environment', 'Path', V)
  //MsgBox(V, mbInformation, MB_OK);
end;

procedure RemoveFromPath();
var
  V: string;
  Str: string;
begin
  RegQueryStringValue(HKLM, 'SYSTEM\CurrentControlSet\Control\Session Manager\Environment', 'Path', V)
  Str := ExpandConstant('{app}');
  V := Replace(V, Str, '');
  V := Replace(V,';;',';');
  RegWriteStringValue(HKLM, 'SYSTEM\CurrentControlSet\Control\Session Manager\Environment', 'Path', V)
  //MsgBox(V, mbInformation, MB_OK);
end;

procedure DeinitializeSetup();
begin
  AppendToPath();
end;

procedure DeinitializeUninstall();
begin
  RemoveFromPath();
end;



