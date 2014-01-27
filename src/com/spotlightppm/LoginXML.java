/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spotlightppm;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Mathew
 */
public class LoginXML {

    String uri = "";
    File file = null;
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
    DocumentBuilder docBuilder = null;

    public LoginXML() {
        try {
            uri = "C:\\Users\\Mathew\\Desktop\\FlashlightDocs\\login.xml";
            file = new File(uri);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            readLoginXML();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LoginXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        //(new LoginXML()).writeLoginXMLSkeleton();
        (new LoginXML()).writeLoginCredentials("mathew", "spotlight");
    }

    void readLoginXML() {

        if (!file.exists()) {
            writeLoginXMLSkeleton();
        } else {
            try {
                Document doc = docBuilder.parse(file);
                Node usernameNode = doc.getDocumentElement().getElementsByTagName("username").item(0);
                Node passwordNode = doc.getDocumentElement().getElementsByTagName("password").item(0);
                username = usernameNode.getTextContent();
                password = passwordNode.getTextContent();

            } catch (SAXException | IOException ex) {
                Logger.getLogger(LoginXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeLoginCredentials(String newUsername, String newPassword) {
        try {
            username = newUsername;
            password = newPassword;

            Document doc = docBuilder.parse(file);

            Node usernameNode = doc.getDocumentElement().getElementsByTagName("username").item(0);
            Node passwordNode = doc.getDocumentElement().getElementsByTagName("password").item(0);
            usernameNode.setTextContent(username);
            passwordNode.setTextContent(password);

            fileWrite(doc);
        } catch (SAXException ex) {
            Logger.getLogger(LoginXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void fileWrite(Document doc) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(LoginXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(LoginXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void writeLoginXMLSkeleton() {

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("login");
        Element usernameElement = doc.createElement("username");
        Element passwordElement = doc.createElement("password");
        doc.appendChild(rootElement);
        rootElement.appendChild(usernameElement);
        rootElement.appendChild(passwordElement);

        fileWrite(doc);

    }
}
