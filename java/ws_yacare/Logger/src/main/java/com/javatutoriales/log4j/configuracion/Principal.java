/*
 * Principal.java
 *
 * Creada el 15/04/2011, 09:29:35 AM
 *
 * Clase Java desarrollada por Alex para el blog http://javatutoriales.com/ el día 15/04/2011
 *
 * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
 * programadorjavablog@gmail.com
 *
 * No olviden hacerse fans del grupo de Java Tutoriales en facebook  http://www.facebook.com/pages/Java-Tutoriales/121935157864634
 *
 */
package com.javatutoriales.log4j.configuracion;

import org.apache.log4j.Logger;

/**
 * @author Alex
 * @version 1.0
 * @author-mail programadorjavablog@gmail.com
 * @date 15/04/2011
 */
public class Principal
{
    private static Logger log = Logger.getLogger(Principal.class);

    /**
     * @param args argumentos recibidos por la linea de comandos
     */
    public static void main(String[] args)
    {
        if (log.isTraceEnabled())
        {
            log.trace("mensaje de trace");
        }

        if (log.isDebugEnabled())
        {
            log.debug("mensaje de debug");
        }

        if (log.isInfoEnabled())
        {
            log.info("mensaje de info");
        }
        
        log.warn("mensaje de warn");
        log.error("mensaje de error");
        log.fatal("mensaje de fatal ccccc");
        
        
    }
}
