<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<applicationModel>
    <name>Application Model</name>
    <className>AOSmodel</className>
    <objects>
        <object type="Application" technology="Mobile">
            <name>Advantage Shopping</name>
            <codeName>AOS</codeName>
            <description></description>
            <identification>
                <properties>
                    <property name="Identifier" type="string" isRegExp="false">com.advantageonlineshopping.advantage</property>
                    <property name="IsPackaged" type="boolean" isRegExp="false">true</property>
                </properties>
            </identification>
            <children>
                <object type="Label" technology="Mobile">
                    <name>SPEAKERS</name>
                    <codeName>SPEAKERS</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">3</property>
                            <property name="ResourceId" type="string" isRegExp="false">textViewCategory</property>
                            <property name="Text" type="string" isRegExp="false">SPEAKERS</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>BOSE SOUNDLINK BLUETOOTH SPEAKER III</name>
                    <codeName>BOSE</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="ResourceId" type="string" isRegExp="false">textViewProductName</property>
                            <property name="Text" type="string" isRegExp="false">BOSE SOUNDLINK BLUETOOTH SPEAKER III</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>COLORLabel</name>
                    <codeName>COLORLabel</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">6</property>
                            <property name="ResourceId" type="string" isRegExp="false">textViewProductColorTitle</property>
                            <property name="Text" type="string" isRegExp="false">COLOR</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>PUTINCART</name>
                    <codeName>PUTINCART</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">buttonProductAddToCart</property>
                            <property name="Text" type="string" isRegExp="false">PONER EN CARRITO</property>
                        </properties>
                    </identification>
                </object>
                <object type="UiObject" technology="Mobile">
                    <name>frameLayoutBottonSeccion</name>
                    <codeName>FrameLayoutBottonSeccionUiObject</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">View</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">13</property>
                            <property name="ResourceId" type="string" isRegExp="false">frameLayoutBottonSeccion</property>
                        </properties>
                    </identification>
                </object>
            </children>
        </object>
    </objects>
</applicationModel>
