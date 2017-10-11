
/** ----------------------------------------------------------------------------------------------------
* 
*	This code was automatically generated by the LeanFT Application Model code generator.
*
*	Changes to this file may cause incorrect behavior and will be lost 
*	when the code is regenerated.
*
*   ----------------------------------------------------------------------------------------------------
*/
package net.mf;

import javax.annotation.Generated;

import com.hp.lft.sdk.*;
import com.hp.lft.sdk.internal.*;

@Generated(value = { "This class is automatically generated by the LeanFT Application Model code generator - version \"14.00\"" })
public class AOSmodel extends AppModelBase {		private AOS AOS;
	
	public AOSmodel(TestObject contextTestObject) throws GeneralLeanFtException
	{
		setName("AOSmodel");
				AOS = new AOS(contextTestObject, this);
		rebuildDescriptions();
	}	

			public AOS AOS() { return AOS; }

		public class AOS extends ApplicationNodeBase
	{

		
			private SPEAKERS SPEAKERS;
	private BOSE BOSE;
	private COLORLabel COLORLabel;
	private PUTINCART PUTINCART;
	private FrameLayoutBottonSeccionUiObject FrameLayoutBottonSeccionUiObject;
						public AOS(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);

					SPEAKERS = new SPEAKERS(this, applicationModel);
		BOSE = new BOSE(this, applicationModel);
		COLORLabel = new COLORLabel(this, applicationModel);
		PUTINCART = new PUTINCART(this, applicationModel);
		FrameLayoutBottonSeccionUiObject = new FrameLayoutBottonSeccionUiObject(this, applicationModel);

			setDisplayName("Advantage Shopping");
		}

		@Override
		protected com.hp.lft.sdk.mobile.ApplicationDescription createDescription() throws GeneralLeanFtException{
			com.hp.lft.sdk.mobile.ApplicationDescription description = null; 
			try{
				description = new com.hp.lft.sdk.mobile.ApplicationDescription.Builder().identifier("com.advantageonlineshopping.advantage").packaged(true).build();
			}catch(Exception e){
				throw new GeneralLeanFtException(e.getMessage(), e);
			}
			return description;
		}

				public SPEAKERS SPEAKERS() { return SPEAKERS; }
		public BOSE BOSE() { return BOSE; }
		public COLORLabel COLORLabel() { return COLORLabel; }
		public PUTINCART PUTINCART() { return PUTINCART; }
		public FrameLayoutBottonSeccionUiObject FrameLayoutBottonSeccionUiObject() { return FrameLayoutBottonSeccionUiObject; }
		
			public class SPEAKERS extends LabelNodeBase
	{

		
								public SPEAKERS(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);

			
			setDisplayName("SPEAKERS");
		}

		@Override
		protected com.hp.lft.sdk.mobile.LabelDescription createDescription() throws GeneralLeanFtException{
			com.hp.lft.sdk.mobile.LabelDescription description = null; 
			try{
				description = new com.hp.lft.sdk.mobile.LabelDescription.Builder().className("Label").mobileCenterIndex(3).resourceId("textViewCategory").text("SPEAKERS").build();
			}catch(Exception e){
				throw new GeneralLeanFtException(e.getMessage(), e);
			}
			return description;
		}

				
			}

	public class BOSE extends LabelNodeBase
	{

		
								public BOSE(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);

			
			setDisplayName("BOSE SOUNDLINK BLUETOOTH SPEAKER III");
		}

		@Override
		protected com.hp.lft.sdk.mobile.LabelDescription createDescription() throws GeneralLeanFtException{
			com.hp.lft.sdk.mobile.LabelDescription description = null; 
			try{
				description = new com.hp.lft.sdk.mobile.LabelDescription.Builder().className("Label").resourceId("textViewProductName").text("BOSE SOUNDLINK BLUETOOTH SPEAKER III").build();
			}catch(Exception e){
				throw new GeneralLeanFtException(e.getMessage(), e);
			}
			return description;
		}

				
			}

	public class COLORLabel extends LabelNodeBase
	{

		
								public COLORLabel(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);

			
			setDisplayName("COLORLabel");
		}

		@Override
		protected com.hp.lft.sdk.mobile.LabelDescription createDescription() throws GeneralLeanFtException{
			com.hp.lft.sdk.mobile.LabelDescription description = null; 
			try{
				description = new com.hp.lft.sdk.mobile.LabelDescription.Builder().className("Label").mobileCenterIndex(6).resourceId("textViewProductColorTitle").text("COLOR").build();
			}catch(Exception e){
				throw new GeneralLeanFtException(e.getMessage(), e);
			}
			return description;
		}

				
			}

	public class PUTINCART extends ButtonNodeBase
	{

		
								public PUTINCART(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);

			
			setDisplayName("PUTINCART");
		}

		@Override
		protected com.hp.lft.sdk.mobile.ButtonDescription createDescription() throws GeneralLeanFtException{
			com.hp.lft.sdk.mobile.ButtonDescription description = null; 
			try{
				description = new com.hp.lft.sdk.mobile.ButtonDescription.Builder().className("Button").resourceId("buttonProductAddToCart").text("PONER EN CARRITO").build();
			}catch(Exception e){
				throw new GeneralLeanFtException(e.getMessage(), e);
			}
			return description;
		}

				
			}

	public class FrameLayoutBottonSeccionUiObject extends UiObjectNodeBase
	{

		
								public FrameLayoutBottonSeccionUiObject(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);

			
			setDisplayName("frameLayoutBottonSeccion");
		}

		@Override
		protected com.hp.lft.sdk.mobile.UiObjectDescription createDescription() throws GeneralLeanFtException{
			com.hp.lft.sdk.mobile.UiObjectDescription description = null; 
			try{
				description = new com.hp.lft.sdk.mobile.UiObjectDescription.Builder().className("View").mobileCenterIndex(13).resourceId("frameLayoutBottonSeccion").build();
			}catch(Exception e){
				throw new GeneralLeanFtException(e.getMessage(), e);
			}
			return description;
		}

				
			}

	}


			
	public abstract class ApplicationNodeBase extends AppModelNodeBase<com.hp.lft.sdk.mobile.Application, com.hp.lft.sdk.mobile.ApplicationDescription> implements com.hp.lft.sdk.mobile.Application
	{		
		public ApplicationNodeBase(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);
		}

		


		@Override 
		public <TChild extends TestObject> TChild describe(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().describe(arg0, arg1);
		}

		@Override 
		public boolean exists() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists();
		}

		@Override 
		public boolean exists(java.lang.Integer arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists(arg0);
		}

		@Override 
		public <TChild extends TestObject> TChild[] findChildren(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().findChildren(arg0, arg1);
		}

		@Override 
		public java.lang.String getDisplayName()  
		{
			return getConcrete().getDisplayName();
		}

		@Override 
		public java.lang.String getIdentifier() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getIdentifier();
		}

		@Override 
		public java.lang.String getName() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getName();
		}

		@Override 
		public java.awt.image.RenderedImage getSnapshot() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getSnapshot();
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0);
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0, java.awt.Rectangle arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0, arg1);
		}

		@Override 
		public java.lang.String getVersion() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVersion();
		}

		@Override 
		public java.lang.String getVisibleText() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText();
		}

		@Override 
		public java.lang.String getVisibleText(java.awt.Rectangle arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText(arg0);
		}

		@Override 
		public void highlight() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().highlight();
		}

		@Override 
		public <TChild extends TestObject> int highlightMatches(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().highlightMatches(arg0, arg1);
		}

		@Override 
		public void install() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().install();
		}

		@Override 
		public void kill() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().kill();
		}

		@Override 
		public void launch() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().launch();
		}

		@Override 
		public void restart() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().restart();
		}

		@Override 
		public void setDisplayName(java.lang.String arg0)  
		{
			getConcrete().setDisplayName(arg0);
		}

		@Override 
		public void uninstall() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().uninstall();
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0);
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2, byte arg3) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2, arg3);
		}
	}
	
	public abstract class LabelNodeBase extends AppModelNodeBase<com.hp.lft.sdk.mobile.Label, com.hp.lft.sdk.mobile.LabelDescription> implements com.hp.lft.sdk.mobile.Label
	{		
		public LabelNodeBase(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);
		}

		


		@Override 
		public <TChild extends TestObject> TChild describe(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().describe(arg0, arg1);
		}

		@Override 
		public boolean exists() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists();
		}

		@Override 
		public boolean exists(java.lang.Integer arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists(arg0);
		}

		@Override 
		public <TChild extends TestObject> TChild[] findChildren(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().findChildren(arg0, arg1);
		}

		@Override 
		public java.lang.String getAccessibilityId() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getAccessibilityId();
		}

		@Override 
		public java.lang.String getClassName() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getClassName();
		}

		@Override 
		public java.lang.String getContainer() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getContainer();
		}

		@Override 
		public java.lang.String getDisplayName()  
		{
			return getConcrete().getDisplayName();
		}

		@Override 
		public java.awt.Point getLocation() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getLocation();
		}

		@Override 
		public java.lang.String getResourceId() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getResourceId();
		}

		@Override 
		public java.awt.Dimension getSize() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getSize();
		}

		@Override 
		public java.awt.image.RenderedImage getSnapshot() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getSnapshot();
		}

		@Override 
		public java.lang.String getText() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getText();
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0);
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0, java.awt.Rectangle arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0, arg1);
		}

		@Override 
		public java.lang.String getVisibleText() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText();
		}

		@Override 
		public java.lang.String getVisibleText(java.awt.Rectangle arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText(arg0);
		}

		@Override 
		public void highlight() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().highlight();
		}

		@Override 
		public <TChild extends TestObject> int highlightMatches(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().highlightMatches(arg0, arg1);
		}

		@Override 
		public boolean isCheckable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isCheckable();
		}

		@Override 
		public boolean isChecked() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isChecked();
		}

		@Override 
		public boolean isClickable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isClickable();
		}

		@Override 
		public boolean isEnabled() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isEnabled();
		}

		@Override 
		public boolean isFocusable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isFocusable();
		}

		@Override 
		public boolean isFocused() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isFocused();
		}

		@Override 
		public void longPress() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().longPress();
		}

		@Override 
		public void longPress(com.hp.lft.sdk.mobile.LongPressArgs arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().longPress(arg0);
		}

		@Override 
		public void pan(com.hp.lft.sdk.Location arg0, com.hp.lft.sdk.Location arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1);
		}

		@Override 
		public void pan(java.awt.Point arg0, java.awt.Point arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1);
		}

		@Override 
		public void pan(java.awt.Point arg0, java.awt.Point arg1, com.hp.lft.sdk.mobile.PanArgs arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1, arg2);
		}

		@Override 
		public void pinch(double arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pinch(arg0);
		}

		@Override 
		public void pinch(double arg0, com.hp.lft.sdk.mobile.PinchArgs arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pinch(arg0, arg1);
		}

		@Override 
		public void setDisplayName(java.lang.String arg0)  
		{
			getConcrete().setDisplayName(arg0);
		}

		@Override 
		public void swipe(com.hp.lft.sdk.SwipeDirection arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().swipe(arg0);
		}

		@Override 
		public void swipe(com.hp.lft.sdk.SwipeDirection arg0, com.hp.lft.sdk.mobile.SwipeArgs arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().swipe(arg0, arg1);
		}

		@Override 
		public void tap() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().tap();
		}

		@Override 
		public void tap(com.hp.lft.sdk.mobile.TapArgs arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().tap(arg0);
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0);
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2, byte arg3) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2, arg3);
		}
	}
	
	public abstract class ButtonNodeBase extends AppModelNodeBase<com.hp.lft.sdk.mobile.Button, com.hp.lft.sdk.mobile.ButtonDescription> implements com.hp.lft.sdk.mobile.Button
	{		
		public ButtonNodeBase(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);
		}

		


		@Override 
		public <TChild extends TestObject> TChild describe(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().describe(arg0, arg1);
		}

		@Override 
		public boolean exists() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists();
		}

		@Override 
		public boolean exists(java.lang.Integer arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists(arg0);
		}

		@Override 
		public <TChild extends TestObject> TChild[] findChildren(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().findChildren(arg0, arg1);
		}

		@Override 
		public java.lang.String getAccessibilityId() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getAccessibilityId();
		}

		@Override 
		public java.lang.String getClassName() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getClassName();
		}

		@Override 
		public java.lang.String getContainer() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getContainer();
		}

		@Override 
		public java.lang.String getDisplayName()  
		{
			return getConcrete().getDisplayName();
		}

		@Override 
		public java.awt.Point getLocation() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getLocation();
		}

		@Override 
		public java.lang.String getResourceId() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getResourceId();
		}

		@Override 
		public java.awt.Dimension getSize() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getSize();
		}

		@Override 
		public java.awt.image.RenderedImage getSnapshot() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getSnapshot();
		}

		@Override 
		public java.lang.String getText() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getText();
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0);
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0, java.awt.Rectangle arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0, arg1);
		}

		@Override 
		public java.lang.String getVisibleText() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText();
		}

		@Override 
		public java.lang.String getVisibleText(java.awt.Rectangle arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText(arg0);
		}

		@Override 
		public void highlight() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().highlight();
		}

		@Override 
		public <TChild extends TestObject> int highlightMatches(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().highlightMatches(arg0, arg1);
		}

		@Override 
		public boolean isClickable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isClickable();
		}

		@Override 
		public boolean isEnabled() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isEnabled();
		}

		@Override 
		public boolean isFocusable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isFocusable();
		}

		@Override 
		public boolean isFocused() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isFocused();
		}

		@Override 
		public void longPress() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().longPress();
		}

		@Override 
		public void longPress(com.hp.lft.sdk.mobile.LongPressArgs arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().longPress(arg0);
		}

		@Override 
		public void pan(com.hp.lft.sdk.Location arg0, com.hp.lft.sdk.Location arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1);
		}

		@Override 
		public void pan(java.awt.Point arg0, java.awt.Point arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1);
		}

		@Override 
		public void pan(java.awt.Point arg0, java.awt.Point arg1, com.hp.lft.sdk.mobile.PanArgs arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1, arg2);
		}

		@Override 
		public void pinch(double arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pinch(arg0);
		}

		@Override 
		public void pinch(double arg0, com.hp.lft.sdk.mobile.PinchArgs arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pinch(arg0, arg1);
		}

		@Override 
		public void setDisplayName(java.lang.String arg0)  
		{
			getConcrete().setDisplayName(arg0);
		}

		@Override 
		public void swipe(com.hp.lft.sdk.SwipeDirection arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().swipe(arg0);
		}

		@Override 
		public void swipe(com.hp.lft.sdk.SwipeDirection arg0, com.hp.lft.sdk.mobile.SwipeArgs arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().swipe(arg0, arg1);
		}

		@Override 
		public void tap() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().tap();
		}

		@Override 
		public void tap(com.hp.lft.sdk.mobile.TapArgs arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().tap(arg0);
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0);
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2, byte arg3) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2, arg3);
		}
	}
	
	public abstract class UiObjectNodeBase extends AppModelNodeBase<com.hp.lft.sdk.mobile.UiObject, com.hp.lft.sdk.mobile.UiObjectDescription> implements com.hp.lft.sdk.mobile.UiObject
	{		
		public UiObjectNodeBase(TestObject parent, AppModelBase applicationModel) throws GeneralLeanFtException
		{
			super(parent, applicationModel);
		}

		


		@Override 
		public <TChild extends TestObject> TChild describe(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().describe(arg0, arg1);
		}

		@Override 
		public boolean exists() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists();
		}

		@Override 
		public boolean exists(java.lang.Integer arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().exists(arg0);
		}

		@Override 
		public <TChild extends TestObject> TChild[] findChildren(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().findChildren(arg0, arg1);
		}

		@Override 
		public java.lang.String getAccessibilityId() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getAccessibilityId();
		}

		@Override 
		public java.lang.String getClassName() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getClassName();
		}

		@Override 
		public java.lang.String getContainer() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getContainer();
		}

		@Override 
		public java.lang.String getDisplayName()  
		{
			return getConcrete().getDisplayName();
		}

		@Override 
		public java.awt.Point getLocation() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getLocation();
		}

		@Override 
		public java.lang.String getResourceId() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getResourceId();
		}

		@Override 
		public java.awt.Dimension getSize() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getSize();
		}

		@Override 
		public java.awt.image.RenderedImage getSnapshot() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getSnapshot();
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0);
		}

		@Override 
		public java.awt.Rectangle[] getTextLocations(java.lang.String arg0, java.awt.Rectangle arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getTextLocations(arg0, arg1);
		}

		@Override 
		public java.lang.String getVisibleText() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText();
		}

		@Override 
		public java.lang.String getVisibleText(java.awt.Rectangle arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().getVisibleText(arg0);
		}

		@Override 
		public void highlight() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().highlight();
		}

		@Override 
		public <TChild extends TestObject> int highlightMatches(java.lang.Class<TChild> arg0, com.hp.lft.sdk.Description arg1) throws com.hp.lft.sdk.GeneralLeanFtException, java.lang.CloneNotSupportedException 
		{
			return getConcrete().highlightMatches(arg0, arg1);
		}

		@Override 
		public boolean isCheckable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isCheckable();
		}

		@Override 
		public boolean isChecked() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isChecked();
		}

		@Override 
		public boolean isClickable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isClickable();
		}

		@Override 
		public boolean isEnabled() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isEnabled();
		}

		@Override 
		public boolean isFocusable() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isFocusable();
		}

		@Override 
		public boolean isFocused() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().isFocused();
		}

		@Override 
		public void longPress() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().longPress();
		}

		@Override 
		public void longPress(com.hp.lft.sdk.mobile.LongPressArgs arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().longPress(arg0);
		}

		@Override 
		public void pan(com.hp.lft.sdk.Location arg0, com.hp.lft.sdk.Location arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1);
		}

		@Override 
		public void pan(java.awt.Point arg0, java.awt.Point arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1);
		}

		@Override 
		public void pan(java.awt.Point arg0, java.awt.Point arg1, com.hp.lft.sdk.mobile.PanArgs arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pan(arg0, arg1, arg2);
		}

		@Override 
		public void pinch(double arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pinch(arg0);
		}

		@Override 
		public void pinch(double arg0, com.hp.lft.sdk.mobile.PinchArgs arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().pinch(arg0, arg1);
		}

		@Override 
		public void setDisplayName(java.lang.String arg0)  
		{
			getConcrete().setDisplayName(arg0);
		}

		@Override 
		public void setFocus() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().setFocus();
		}

		@Override 
		public void swipe(com.hp.lft.sdk.SwipeDirection arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().swipe(arg0);
		}

		@Override 
		public void swipe(com.hp.lft.sdk.SwipeDirection arg0, com.hp.lft.sdk.mobile.SwipeArgs arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().swipe(arg0, arg1);
		}

		@Override 
		public void tap() throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().tap();
		}

		@Override 
		public void tap(com.hp.lft.sdk.mobile.TapArgs arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			getConcrete().tap(arg0);
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0);
		}

		@Override 
		public java.awt.Point verifyImageExists(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageExists(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, byte arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2);
		}

		@Override 
		public boolean verifyImageMatch(java.awt.image.RenderedImage arg0, com.hp.lft.sdk.ImageMaskArea arg1, byte arg2, byte arg3) throws com.hp.lft.sdk.GeneralLeanFtException 
		{
			return getConcrete().verifyImageMatch(arg0, arg1, arg2, arg3);
		}
	}
}
