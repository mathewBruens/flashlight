/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spotlightppm;

/**
 *
 * @author Mathew
 */
public class UserSettings {

    boolean useWebcam;
    long webcamMinInterval;
    long webcamMaxInterval;
    String webcamResolution; //"LOW" "MEDIUM" "HIGH"

    boolean useScreenshot;
    long screenshotMinInterval;
    long screenshotMaxInterval;
    String screenshotResolution; //"LOW" "MEDIUM" "HIGH"
    
    boolean useUserStats;
    long userStatsMinInterval;
    long userStatsMaxInterval;

    public UserSettings(boolean useWebcam, long webcamMinInterval, long webcamMaxInterval,
            String webcamResolution, boolean useScreenshot, long screenshotMinInterval,
            long screenshotMaxInterval, String screenshotResolution, boolean useUserStats,
            long userStatsMinInterval, long userStatsMaxInterval) {

        this.useWebcam = useWebcam;
        this.webcamMinInterval = webcamMinInterval;
        this.webcamMaxInterval = webcamMaxInterval;
        this.webcamResolution = webcamResolution;
        this.useScreenshot = useScreenshot;
        this.screenshotMinInterval = screenshotMinInterval;
        this.screenshotMaxInterval = screenshotMaxInterval;
        this.screenshotResolution = screenshotResolution;
        this.useUserStats = useUserStats;
        this.userStatsMinInterval = userStatsMinInterval;
        this.userStatsMaxInterval = userStatsMaxInterval;
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

    public String getScreenshotResolution() {
        return screenshotResolution;
    }

    public void setScreenshotResolution(String screenshotResolution) {
        this.screenshotResolution = screenshotResolution;
    }

    public boolean isUseUserStats() {
        return useUserStats;
    }

    public void setUseUserStats(boolean useUserStats) {
        this.useUserStats = useUserStats;
    }

    public long getUserStatsMinInterval() {
        return userStatsMinInterval;
    }

    public void setUserStatsMinInterval(long userStatsMinInterval) {
        this.userStatsMinInterval = userStatsMinInterval;
    }

    public long getUserStatsMaxInterval() {
        return userStatsMaxInterval;
    }

    public void setUserStatsMaxInterval(long userStatsMaxInterval) {
        this.userStatsMaxInterval = userStatsMaxInterval;
    }


    public boolean isUseWebcam() {
        return useWebcam;
    }

    public void setUseWebcam(boolean useWebcam) {
        this.useWebcam = useWebcam;
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

    public String getWebcamResolution() {
        return webcamResolution;
    }

    public void setWebcamResolution(String webcamResolution) {
        this.webcamResolution = webcamResolution;
    }

}
