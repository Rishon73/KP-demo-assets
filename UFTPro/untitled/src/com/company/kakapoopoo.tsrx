<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<applicationModel>
    <name>Application Model</name>
    <className>kakapoopoo</className>
    <objects>
        <object type="Application" technology="Mobile">
            <name>Advantage Shopping</name>
            <codeName>AdvantageShoppingApplication</codeName>
            <identification>
                <properties>
                    <property name="Identifier" type="string" isRegExp="false">com.Advantage.aShopping</property>
                    <property name="IsPackaged" type="boolean" isRegExp="false">false</property>
                </properties>
            </identification>
            <children>
                <object type="Button" technology="Mobile">
                    <name>Connect</name>
                    <codeName>ConnectButton</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">Connect</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">com.Advantage.aShopping:id/buttonConnect</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>OK</name>
                    <codeName>OKButton</codeName>
                    <identification>
                        <properties>
                            <property name="Text" type="string" isRegExp="false">OK</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="ResourceId" type="string" isRegExp="false">android:id/button1</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
            </children>
        </object>
    </objects>
</applicationModel>
