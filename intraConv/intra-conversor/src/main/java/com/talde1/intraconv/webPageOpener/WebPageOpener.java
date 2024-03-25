package com.talde1.intraconv.webPageOpener;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class WebPageOpener {
    
    static String url = "http://192.168.65.110:8069/web/login";  // Reemplaza con la URL de la página web que deseas abrir

    public static void openWebPage() throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                URI uri = new URI(url);
                desktop.browse(uri);
            } else {
                System.out.println("No se admite la acción de navegación en este sistema.");
            }
        } else {
            System.out.println("El soporte para el escritorio no está disponible en este sistema.");
        }
    }
}
