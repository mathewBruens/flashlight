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
public class ServerPush {

    public ServerPush() {
        
    }
    
    public boolean serverLogin(String username, String password){
        return true;
    }
    
    public void pushWebcamImage(byte[] image){
        pushWebcamImage("Mathew", "Password", image);
    }
    
    public void pushScreenshotImage(byte[] image){
        pushScreenshotImage("Mathew", "Password", image);
    }
    
    public void pushUsageStats(){
       // pushUsageStats("Mathew", "Password", int arg2, int arg3, com.spotlightppm.Timestamp arg4, com.spotlightppm.Timestamp arg5, long arg6, long arg7, com.spotlightppm.Timestamp arg8, com.spotlightppm.Timestamp arg9);
        
    }
    
    private static void pushWebcamImage(java.lang.String arg0, java.lang.String arg1, byte[] arg2) {
        com.spotlightppm.ServerService service = new com.spotlightppm.ServerService();
        com.spotlightppm.Server port = service.getServerPort();
        port.pushWebcamImage(arg0, arg1, arg2);
    }



    private static void pushScreenshotImage(java.lang.String arg0, java.lang.String arg1, byte[] arg2) {
        com.spotlightppm.ServerService service = new com.spotlightppm.ServerService();
        com.spotlightppm.Server port = service.getServerPort();
        port.pushScreenshotImage(arg0, arg1, arg2);
    }

    private static void pushUseageStats(java.lang.String arg0, java.lang.String arg1, int arg2, int arg3, com.spotlightppm.Timestamp arg4, com.spotlightppm.Timestamp arg5, long arg6, long arg7, com.spotlightppm.Timestamp arg8, com.spotlightppm.Timestamp arg9) {
        com.spotlightppm.ServerService service = new com.spotlightppm.ServerService();
        com.spotlightppm.Server port = service.getServerPort();
        port.pushUseageStats(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }
    
    
    

    
}
