package com.spotlightppm;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.github.sarxos.webcam.*;

public class Settings {

    String username = "";
    String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebcamImageQuality() {
        return webcamImageQuality;
    }

    public void setWebcamImageQuality(String webcamImageQuality) {
        this.webcamImageQuality = webcamImageQuality;
    }

    public String getScreenshotImageQuality() {
        return screenshotImageQuality;
    }

    public void setScreenshotImageQuality(String screenshotImageQuality) {
        this.screenshotImageQuality = screenshotImageQuality;
    }

    String webcamImageQuality = "HIGH";
    String screenshotImageQuality = "HIGH";//Needs to be changed to implement

    public boolean isUseWebcam() {
        return useWebcam;
    }

    public void setUseWebcam(boolean useWebcam) {
        this.useWebcam = useWebcam;
    }

    public boolean isUseScreenshot() {
        return useScreenshot;
    }

    public void setUseScreenshot(boolean useScreenshot) {
        this.useScreenshot = useScreenshot;
    }

    public long getScreenshotMinInterval() {
        return screenshotMinInterval;
    }

    public void setScreenshotMinInterval(long screenshotMinInterval) {
        this.screenshotMinInterval = screenshotMinInterval;
    }

    public long getScreenshotMaxInterval() {
        return screenshotMaxInterval;
    }

    public void setScreenshotMaxInterval(long screenshotMaxInterval) {
        this.screenshotMaxInterval = screenshotMaxInterval;
    }

    public boolean isUseUserStats() {
        return useUserStats;
    }

    public void setUseUserStats(boolean useUserStats) {
        this.useUserStats = useUserStats;
    }

    public long getUserStatsMaxInterval() {
        return userStatsMaxInterval;
    }

    public void setUserStatsMaxInterval(long userStatsMaxInterval) {
        this.userStatsMaxInterval = userStatsMaxInterval;
    }

    public Map<String, Dimension> getScreenSizeMap() {
        return screenSizeMap;
    }

    public void setScreenSizeMap(Map<String, Dimension> screenSizeMap) {
        this.screenSizeMap = screenSizeMap;
    }

    public long getWebcamMinInterval() {
        return webcamMinInterval;
    }

    public void setWebcamMinInterval(long webcamMinInterval) {
        this.webcamMinInterval = webcamMinInterval;
    }

    public long getWebcamMaxInterval() {
        return webcamMaxInterval;
    }

    public void setWebcamMaxInterval(long webcamMaxInterval) {
        this.webcamMaxInterval = webcamMaxInterval;
    }

    public long getUserStatsMinInterval() {
        return userStatsMinInterval;
    }

    public void setUserStatsMinInterval(long userStatsMinInterval) {
        this.userStatsMinInterval = userStatsMinInterval;
    }
    
    boolean useWebcam =false;
    long webcamMinInterval;
    long webcamMaxInterval;

    boolean useScreenshot = false;
    long screenshotMinInterval;
    long screenshotMaxInterval;

    boolean useUserStats=false;
    long userStatsMinInterval;
    long userStatsMaxInterval;

    GraphicsEnvironment ge = null;

    GraphicsDevice[] screens = null;

    GraphicsDevice activeScreen = null;
    Dimension activeScreenDimension = null;

    Dimension[] screenDimensions = null;

    Webcam activeWebcam = null;

    ArrayList<Webcam> webcamList = null;

    Dimension[] activeWebcamDimensions = null;

    Dimension activeWebcamDimension = null;

    Map<String, Dimension> screenSizeMap = new HashMap<>();

    String[] screenSizeQuality = {"High", "Medium", "Low"};

    final Dimension QQVGA = new Dimension(176, 144);

    final Dimension QVGA = new Dimension(320, 240);

    final Dimension VGA = new Dimension(640, 480);

    final Dimension XGA = new Dimension(1024, 768);

    final Dimension HD720 = new Dimension(1280, 720);

    public Settings() throws WebcamException, TimeoutException {
        initScreenSizeMap();
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        screens = ge.getScreenDevices();
        activeScreen = ge.getDefaultScreenDevice();
        activeScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        activeWebcam = Webcam.getDefault();
        // activeWebcam.setViewSize(WebcamResolution.VGA.getSize());
        webcamList = new ArrayList<Webcam>(Webcam.getWebcams(5000));
        activeWebcamDimensions = activeWebcam.getViewSizes();
		// activeWebcamDimension = WebcamResolution.VGA.getSize();
        // setActiveWebcamDimension(activeWebcamDimension);
    }

    public GraphicsDevice getActiveScreen() {
        return activeScreen;
    }

    public Dimension getActiveScreenDimension() {
        return activeScreenDimension;
    }

    public Webcam getActiveWebcam() {
        return activeWebcam;
    }

    public Dimension getActiveWebcamDimension() {
        return activeWebcamDimension;
    }

    public Dimension[] getActiveWebcamDimensions() {
        return activeWebcamDimensions;
    }

    public GraphicsEnvironment getGe() {
        return ge;
    }

    public Dimension[] getscreenDimensions() {
        return screenDimensions;
    }

    public GraphicsDevice[] getScreens() {
        return screens;
    }

    public String[] getScreenSizeQuality() {
        return screenSizeQuality;
    }

    public ArrayList<Webcam> getWebcamList() {
        return webcamList;
    }

    public void initScreenSizeMap() {
        Dimension maxDimension = Toolkit.getDefaultToolkit().getScreenSize();
        double maxHeight = maxDimension.getHeight();
        @SuppressWarnings("unused")
        double maxWidth = maxDimension.getWidth();
        screenSizeMap.put("High", maxDimension);

        if (screenSizeMap.get("High").width > 640) {
            screenSizeMap.put("Medium", VGA);
            screenSizeMap.put("Low", QVGA);
        }
    }

    public void setActiveScreen(GraphicsDevice activeScreen) {
        this.activeScreen = activeScreen;
    }

    public void setActiveScreenDimension(String quality) {
        Dimension dimension = screenSizeMap.get(quality);
        if (dimension == null) {
            activeScreenDimension = (Toolkit.getDefaultToolkit()
                    .getScreenSize());
        } else {
            activeScreenDimension = dimension;
        }
    }

    public void setActiveWebcam(Webcam activeWebcam) {
        this.activeWebcam = activeWebcam;
    }

    public void setActiveWebcamDimension(final Dimension activeWebcamDimension) {
        this.activeWebcamDimension = activeWebcamDimension;

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                while (activeWebcam.isOpen()) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                activeWebcam.setViewSize(activeWebcamDimension);

            }
        }, "Change Webcam Dimension Thread");

        t.start();
    }

    public void setActiveWebcamDimensions(Dimension[] activeWebcamDimensions) {
        this.activeWebcamDimensions = activeWebcamDimensions;
    }

    public void setGe(GraphicsEnvironment ge) {
        this.ge = ge;
    }

    public void setScreenDimensions(Dimension[] screenDimension) {
        this.screenDimensions = screenDimensions;
    }

    public void setScreens(GraphicsDevice[] screens) {
        this.screens = screens;
    }

    public void setScreenSizeQuality(String[] screenSizeQuality) {
        this.screenSizeQuality = screenSizeQuality;
    }

    public void setWebcamList(ArrayList<Webcam> webcamList) {
        this.webcamList = webcamList;
    }

}
