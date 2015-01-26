package com.github.jaxrs_static.bean;

import java.io.Serializable;

public class DeviceDetectionSession implements Serializable {

	private static final long serialVersionUID = 2576409499278106766L;

	public static final String NAME = "deviceDetectionSession";

	private boolean isMobile = false;
	private String formFactor = "";
	private String completeDeviceName = "";
	private boolean isHighDensity = false;
	private boolean isRetina = false;
	private int clientWidth = 0;
	private boolean canResizeBrowserWindow = false;
	private String orientation = "";
	private String htmlClass = "";

	public boolean isMobile() {
		return isMobile;
	}

	public void setMobile(boolean isMobile) {
		this.isMobile = isMobile;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		if (formFactor == null) {
			this.formFactor = "";
		} else {
			this.formFactor = formFactor;
		}
	}

	public boolean isDesktop() {
		return hasValue(formFactor, "Desktop");
	}

	public boolean isApp() {
		return hasValue(formFactor, "App");
	}

	public boolean isTablet() {
		return hasValue(formFactor, "Tablet");
	}

	public boolean isSmartPhone() {
		return hasValue(formFactor, "Smartphone");
	}

	public boolean isFeaturePhone() {
		return hasValue(formFactor, "Feature Phone");
	}

	public boolean isSmartTv() {
		return hasValue(formFactor, "Smart-TV");
	}

	public boolean isRobot() {
		return hasValue(formFactor, "Robot");
	}

	public boolean isOtherNonMobile() {
		return hasValue(formFactor, "Other non-Mobile");
	}

	public boolean isOtherMobile() {
		return hasValue(formFactor, "Other Mobile");
	}

	public String getCompleteDeviceName() {
		return completeDeviceName;
	}

	public void setCompleteDeviceName(String completeDeviceName) {
		if (completeDeviceName == null) {
			this.completeDeviceName = "";
		} else {
			this.completeDeviceName = completeDeviceName;
		}
	}

	public boolean isHighDensity() {
		return isHighDensity;
	}

	public void setHighDensity(boolean isHighDensity) {
		this.isHighDensity = isHighDensity;
	}

	public boolean isRetina() {
		return isRetina;
	}

	public void setRetina(boolean isRetina) {
		this.isRetina = isRetina;
	}

	public int getClientWidth() {
		return clientWidth;
	}

	public void setClientWidth(int clientWidth) {
		if (clientWidth < 0) {
			this.clientWidth = 0;
		} else {
			this.clientWidth = clientWidth;
		}
	}

	public boolean isCanResizeBrowserWindow() {
		return canResizeBrowserWindow;
	}

	public void setCanResizeBrowserWindow(boolean canResizeBrowserWindow) {
		this.canResizeBrowserWindow = canResizeBrowserWindow;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		if (orientation == null) {
			this.orientation = "";
		} else {
			this.orientation = orientation;
		}
	}

	public boolean isLanscape() {
		return hasValue(orientation, "landscape");
	}

	public boolean isPortrait() {
		return hasValue(orientation, "portrait");
	}

	public String getHtmlClass() {
		return htmlClass;
	}

	public void setHtmlClass(String htmlClass) {
		if (htmlClass == null) {
			this.htmlClass = "";
		} else {
			this.htmlClass = " " + htmlClass + " ";
		}
	}

	public boolean isApplicationcacheAvailable() {
		return hasValue(htmlClass, " applicationcache ");
	}

	public boolean isAudioAvailable() {
		return hasValue(htmlClass, " audio ");
	}

	public boolean isBackgroundsizeAvailable() {
		return hasValue(htmlClass, " backgroundsize ");
	}

	public boolean isBorderimageAvailable() {
		return hasValue(htmlClass, " borderimage ");
	}

	public boolean isBorderradiusAvailable() {
		return hasValue(htmlClass, " borderradius ");
	}

	public boolean isBoxshadowAvailable() {
		return hasValue(htmlClass, " boxshadow ");
	}

	public boolean isCanvasAvailable() {
		return hasValue(htmlClass, " canvas ");
	}

	public boolean isCanvastextAvailable() {
		return hasValue(htmlClass, " canvastext ");
	}

	public boolean isCssanimationsAvailable() {
		return hasValue(htmlClass, " cssanimations ");
	}

	public boolean isCsscolumnsAvailable() {
		return hasValue(htmlClass, " csscolumns ");
	}

	public boolean isCssgradientsAvailable() {
		return hasValue(htmlClass, " cssgradients ");
	}

	public boolean isCssreflectionsAvailable() {
		return hasValue(htmlClass, " cssreflections ");
	}

	public boolean isCsstransformsAvailable() {
		return hasValue(htmlClass, " csstransforms ");
	}

	public boolean isCsstransforms3dAvailable() {
		return hasValue(htmlClass, " csstransforms3d ");
	}

	public boolean isCsstransitionsAvailable() {
		return hasValue(htmlClass, " csstransitions ");
	}

	public boolean isDraganddropAvailable() {
		return hasValue(htmlClass, " draganddrop ");
	}

	public boolean isFlexboxAvailable() {
		return hasValue(htmlClass, " flexbox ");
	}

	public boolean isFlexboxlegacyAvailable() {
		return hasValue(htmlClass, " flexboxlegacy ");
	}

	public boolean isFontfaceAvailable() {
		return hasValue(htmlClass, " fontface ");
	}

	public boolean isGeneratedcontentAvailable() {
		return hasValue(htmlClass, " generatedcontent ");
	}

	public boolean isGeolocationAvailable() {
		return hasValue(htmlClass, " geolocation ");
	}

	public boolean isHashchangeAvailable() {
		return hasValue(htmlClass, " hashchange ");
	}

	public boolean isHistoryAvailable() {
		return hasValue(htmlClass, " history ");
	}

	public boolean isHslaAvailable() {
		return hasValue(htmlClass, " hsla ");
	}

	public boolean isIndexeddbAvailable() {
		return hasValue(htmlClass, " indexeddb ");
	}

	public boolean isInlinesvgAvailable() {
		return hasValue(htmlClass, " inlinesvg ");
	}

	public boolean isJavaScriptAvailable() {
		return hasValue(htmlClass, " js ");
	}

	public boolean isLocalstorageAvailable() {
		return hasValue(htmlClass, " localstorage ");
	}

	public boolean isMultiplebgsAvailable() {
		return hasValue(htmlClass, " multiplebgs ");
	}

	public boolean isOpacityAvailable() {
		return hasValue(htmlClass, " opacity ");
	}

	public boolean isPostmessageAvailable() {
		return hasValue(htmlClass, " postmessage ");
	}

	public boolean isRgbaAvailable() {
		return hasValue(htmlClass, " rgba ");
	}

	public boolean isSessionstorageAvailable() {
		return hasValue(htmlClass, " sessionstorage ");
	}

	public boolean isSmilAvailable() {
		return hasValue(htmlClass, " smil ");
	}

	public boolean isSvgAvailable() {
		return hasValue(htmlClass, " svg ");
	}

	public boolean isSvgclippathsAvailable() {
		return hasValue(htmlClass, " svgclippaths ");
	}

	public boolean isTextshadowAvailable() {
		return hasValue(htmlClass, " textshadow ");
	}

	public boolean isTouchAvailable() {
		return hasValue(htmlClass, " touch ");
	}

	public boolean isVideoAvailable() {
		return hasValue(htmlClass, " video ");
	}

	public boolean isWebglAvailable() {
		return hasValue(htmlClass, " webgl ");
	}

	public boolean isWebsocketsAvailable() {
		return hasValue(htmlClass, " websockets ");
	}

	public boolean isWebsqldatabaseAvailable() {
		return hasValue(htmlClass, " websqldatabase ");
	}

	public boolean isWebworkersAvailable() {
		return hasValue(htmlClass, " webworkers ");
	}

	private boolean hasValue(String test, String value) {
		if ((test == null) || (value == null)) {
			return false;
		}

		return (test.toLowerCase().indexOf(value.toLowerCase()) > -1);
	}

}
