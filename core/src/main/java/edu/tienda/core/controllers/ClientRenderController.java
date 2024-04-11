package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ClientRenderController {

    @GetMapping(value = "/clientes.html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClienteAsHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html lang=\"en\"><head>");
        sb.append(" <meta charset=\"UTF-8\"/><title>Clientes</title>")
        .append("</head><body>")
        .append("<div><h1>Cliente</h1></div>")
        .append("<ul>")
        .append("<li>Nombre: Pedro Rios</h1>")
        .append("<li>UserName : prr<li/>")
        .append("</ul>")
        .append("</div>")
        .append("</body>")
        .append("</html>");
        return sb.toString();
    }
     
    @GetMapping(value = "/clientes.xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getClienteAsXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='UTF-8'> \n")
        .append("<client>\n")
        .append("<name>Pedro Rios</name>\n")
        .append("<userName>prr </userName>\n")
        .append("</client>")
        .append("</xml");
        return sb.toString();
    }
    
}
