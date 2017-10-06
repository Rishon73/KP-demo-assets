<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<applicationModel>
    <name>Application Model</name>
    <className>HybridAppModel</className>
    <objects>
        <object type="Application" technology="Mobile">
            <name>CPXOrderStatus</name>
            <codeName>CPXOrderStatusApplication</codeName>
            <identification>
                <properties>
                    <property name="Identifier" type="string" isRegExp="false">com.hpeit.mobile.cpxorderstatus</property>
                    <property name="IsPackaged" type="boolean" isRegExp="false">true</property>
                </properties>
            </identification>
            <children>
                <object type="WebView" technology="Mobile">
                    <name>MobileWebView</name>
                    <codeName>MobileWebView</codeName>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">WebView</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                    <children>
                        <object type="Page" technology="Web">
                            <name>CPX Order Status</name>
                            <codeName>CPXOrderStatusPage</codeName>
                            <identification/>
                            <children>
                                <object type="WebElement" technology="Web">
                                    <name>menu</name>
                                    <codeName>MenuWebElement</codeName>
                                    <identification>
                                        <properties>
                                            <property name="TagName" type="string" isRegExp="false">svg</property>
                                            <property name="InnerText" type="string" isRegExp="false">menu</property>
                                        </properties>
                                    </identification>
                                </object>
                                <object type="WebElement" technology="Web">
                                    <name>home</name>
                                    <codeName>HomeWebElement</codeName>
                                    <identification>
                                        <properties>
                                            <property name="TagName" type="string" isRegExp="false">svg</property>
                                            <property name="InnerText" type="string" isRegExp="false">home</property>
                                        </properties>
                                    </identification>
                                </object>
                                <object type="WebElement" technology="Web">
                                    <name>Watched Orders</name>
                                    <codeName>WatchedOrdersWebElement</codeName>
                                    <identification>
                                        <properties>
                                            <property name="TagName" type="string" isRegExp="false">H5</property>
                                            <property name="InnerText" type="string" isRegExp="false">Watched Orders</property>
                                        </properties>
                                    </identification>
                                </object>
                                <object type="WebElement" technology="Web">
                                    <name>Preferences</name>
                                    <codeName>PreferencesWebElement</codeName>
                                    <identification>
                                        <properties>
                                            <property name="TagName" type="string" isRegExp="false">H5</property>
                                            <property name="InnerText" type="string" isRegExp="false">Preferences</property>
                                        </properties>
                                    </identification>
                                </object>
                                <object type="WebElement" technology="Web">
                                    <name>actions</name>
                                    <codeName>ActionsWebElement</codeName>
                                    <identification>
                                        <properties>
                                            <property name="TagName" type="string" isRegExp="false">svg</property>
                                            <property name="InnerText" type="string" isRegExp="false">actions</property>
                                        </properties>
                                    </identification>
                                </object>
                                <object type="WebElement" technology="Web">
                                    <name>next</name>
                                    <codeName>NextWebElement</codeName>
                                    <identification>
                                        <properties>
                                            <property name="AccessibilityName" type="string" isRegExp="false">next</property>
                                            <property name="TagName" type="string" isRegExp="false">svg</property>
                                            <property name="InnerText" type="string" isRegExp="false">next</property>
                                        </properties>
                                        <index>3</index>
                                    </identification>
                                </object>
                                <object type="WebElement" technology="Web">
                                    <name>WebElement</name>
                                    <codeName>WebElement</codeName>
                                    <identification>
                                        <properties>
                                            <property name="AccessibilityName" type="string" isRegExp="false"></property>
                                            <property name="TagName" type="string" isRegExp="false">path</property>
                                            <property name="InnerText" type="string" isRegExp="false"></property>
                                        </properties>
                                        <index>7</index>
                                    </identification>
                                </object>
                            </children>
                        </object>
                    </children>
                </object>
            </children>
        </object>
    </objects>
</applicationModel>
