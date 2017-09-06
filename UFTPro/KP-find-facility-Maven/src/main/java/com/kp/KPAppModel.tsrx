<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<applicationModel>
    <name>Application Model</name>
    <className>KPAppModel</className>
    <objects>
        <object type="Application" technology="Mobile">
            <name>KP</name>
            <codeName>KPApplication</codeName>
            <identification>
                <properties>
                    <property name="Identifier" type="string" isRegExp="false">org.kp.m</property>
                    <property name="IsPackaged" type="boolean" isRegExp="false">false</property>
                </properties>
            </identification>
            <children>
                <object type="Button" technology="Mobile">
                    <name>Sign In</name>
                    <codeName>SignInButton</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">Sign In</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/sign_in_button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>OK</name>
                    <codeName>InvalidLoginOKButton</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">OK</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">android:id/button1</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>Find a Facility</name>
                    <codeName>FindAFacilityLabel</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">Find a Facility</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/sign_in_facility_locator</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">8</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>CloseImportantMessage</name>
                    <codeName>CloseImportantMessageButton</codeName>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">android:id/button2</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                            <property name="Text" type="string" isRegExp="true">C.*</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>SearchIcon</name>
                    <codeName>SearchIconLabel</codeName>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">SearchIcon</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                        </properties>
                    </identification>
                </object>
                <object type="EditField" technology="Mobile">
                    <name>org.kp.m:id/search_addre</name>
                    <codeName>SearchAddressEditField</codeName>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Input</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/search_address_edit_text</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>Filter</name>
                    <codeName>FilterLabel</codeName>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">Filter</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>Emergency Services</name>
                    <codeName>EmergencyServicesLabel</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">Emergency Services</property>
                            <property name="ClassName" type="string" isRegExp="false">CheckedLabel</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/checked_row_text_view</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">3</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>FiltersOK</name>
                    <codeName>FiltersOKButton</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">OK</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">android:id/button1</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                        </properties>
                    </identification>
                </object>
                <object type="Toggle" technology="Mobile">
                    <name>List</name>
                    <codeName>ListToggle</codeName>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">List</property>
                            <property name="ClassName" type="string" isRegExp="false">ToggleButton</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/locator_list_button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>Los Angeles Medical Cent</name>
                    <codeName>LosAngelesMedicalCentLabel</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">Los Angeles Medical Center</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/locator_favorites_row_title</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">6</property>
                        </properties>
                    </identification>
                </object>
                <object type="UiObject" technology="Mobile">
                    <name>org.kp.m:id/buttonPanel</name>
                    <codeName>OrgKpMIdButtonPanelUiObject</codeName>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">View</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/buttonPanel</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">10</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>Find a Facility-old</name>
                    <codeName>FindAFacilityLabel_old</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">Find a Facility2</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/sign_in_facility_locator</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">8</property>
                        </properties>
                    </identification>
                </object>
                <object type="UiObject" technology="Mobile">
                    <name>org.kp.m:id/customedMyLo</name>
                    <codeName>OrgKpMIdCustomedMyLoUiObject</codeName>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">ImageView</property>
                            <property name="ResourceId" type="string" isRegExp="false">org.kp.m:id/customedMyLocationButton</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">2</property>
                        </properties>
                    </identification>
                </object>
            </children>
        </object>
        <object type="Application" technology="Mobile">
            <name>Package installer</name>
            <codeName>PackageInstallerApplication</codeName>
            <identification>
                <properties>
                    <property name="Identifier" type="string" isRegExp="false">com.google.android.packageinstaller</property>
                    <property name="IsPackaged" type="boolean" isRegExp="false">false</property>
                </properties>
            </identification>
            <children>
                <object type="Button" technology="Mobile">
                    <name>AllowLocations</name>
                    <codeName>AllowLocationsButton</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="true">(?i)ALLOW</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">com.android.packageinstaller:id/permission_allow_button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>AllowContacts</name>
                    <codeName>AllowContactsButton</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="true">(?i)ALLOW</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">com.android.packageinstaller:id/permission_allow_button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                        </properties>
                    </identification>
                </object>
            </children>
        </object>
    </objects>
</applicationModel>
