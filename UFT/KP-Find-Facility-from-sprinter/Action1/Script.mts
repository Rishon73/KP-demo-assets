'v2-----------------------[Application Settings]-----------------------
'Select the following addins at the 'Add-in Manager':
'Mobile
'
'Use the following application settings in the 'Record and Run Settings' or in 'Application Areas':
'Application type: Mobile
'Application: org.kp.m
'--------------------------------------------------------------------
'
'Step 1
Device("#Device").App("KP").MobileEdit("org.kp.m:id/sign_in_user").SetFocus
Device("#Device").Back
'Step 2
Device("#Device").App("KP").MobileLabel("Find a Facility").Tap
'Step 3
wait 1
if Device("#Device").App("Package installer").MobileButton("Allow").Exist then
	Device("#Device").App("Package installer").MobileButton("Allow").Tap
end if
'Step 5
Device("#Device").App("KP").MobileButton("Close").Tap
Device("#Device").App("KP").MobileLabel("SearchIcon").Tap
'Step 6
Device("#Device").App("KP").MobileEdit("org.kp.m:id/search_addre").Tap
Device("#Device").App("KP").MobileEdit("org.kp.m:id/search_addre").SetFocus
Device("#Device").EnterKeys 0,"94566"
Device("#Device").InsightObject("InsightObject_4").Click @@ hightlight id_;_15_;_script infofile_;_ZIP::ssf5.xml_;_
'Step 7
Device("#Device").App("KP").MobileLabel("Filter").Tap
'Step 8
Device("#Device").App("KP").MobileLabel("Emergency Services").Tap
Device("#Device").App("KP").MobileButton("OK").Tap
'Step 9
Device("#Device").App("KP").MobileToggle("List").Set "on"
'Step 10
Device("#Device").App("KP").MobileObject("MobileObject").Tap
'Step 11
if Device("#Device").App("Package installer").MobileButton("Allow").Exist then
	Device("#Device").App("Package installer").MobileButton("Allow").Tap
end if

 @@ hightlight id_;_7_;_script infofile_;_ZIP::ssf2.xml_;_
