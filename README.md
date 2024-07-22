<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Documentación de la clase GuardarPanelComoImagen</code></h1>

<h2>Descripción</h2>
<p>Este componente Java permite guardar el contenido de un <code>JPanel</code> como una imagen en formato PNG. Está diseñado para ser usado en aplicaciones Java Swing, pudiendo ser añadido fácilmente a <code>JFrame</code> o <code>JDialog</code>.</p>
<p>El componente desarrollado consta de una clase principal, <code>GuardarPanelComoImagen</code>, que permite seleccionar la ubicación y el nombre del archivo donde se guardará la imagen del panel.</p>

<h2>Usos</h2>
<ul>
    <li><strong>Aplicaciones de Diseño Gráfico:</strong> El componente puede ser integrado en aplicaciones donde se requiera guardar el contenido de paneles gráficos como imágenes.</li>
    <li><strong>Herramientas de Presentación:</strong> Útil para guardar diapositivas o contenidos visuales creados en aplicaciones de presentación.</li>
    <li><strong>Desarrollo de Interfaces de Usuario:</strong> Facilita la captura de pantallas de interfaces de usuario desarrolladas en Swing para documentación o análisis.</li>
</ul>

<h2>Características</h2>
<ul>
    <li>Guardado de contenido de <code>JPanel</code> como imagen en formato PNG.</li>
    <li>Selección de ubicación y nombre de archivo mediante <code>JFileChooser</code>.</li>
    <li>Verificación automática y adición de extensión ".png" si no se proporciona.</li>
</ul>

<h2>Requisitos</h2>
<ul>
    <li>Java JDK 8 o superior.</li>
    <li>IDE con soporte para Swing si se desea visualizar el componente gráficamente (por ejemplo, NetBeans o IntelliJ IDEA).</li>
</ul>

<h2>API</h2>

<h3>GuardarPanelComoImagen</h3>

<h4>Descripción</h4>
<p>La clase <code>GuardarPanelComoImagen</code> es responsable de capturar el contenido de un <code>JPanel</code> y guardarlo como una imagen en formato PNG. Proporciona un método estático para realizar esta operación de manera sencilla.</p>

<h4>Métodos</h4>
<ul>
    <li><code>guardarPanelComoImagen</code>
        <pre><code>public static void guardarPanelComoImagen(JPanel panel)</code></pre>
        <p>Genera una imagen del <code>JPanel</code> proporcionado y la guarda en un archivo seleccionado por el usuario.</p>
    </li>
</ul>

<h2>Detalle del Código</h2>

<pre><code>package panelpng;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuardarPanelComoImagen {

    public static void guardarPanelComoImagen(JPanel panel) {
        BufferedImage imagen = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = imagen.createGraphics();
        panel.paint(g2);
        g2.dispose();

        JFileChooser selectorArchivo = new JFileChooser();
        if (selectorArchivo.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION) {
            File archivo = selectorArchivo.getSelectedFile();
            if (!archivo.getAbsolutePath().endsWith(".png")) {
                archivo = new File(archivo + ".png");
            }
            try {
                ImageIO.write(imagen, "png", archivo);
                JOptionPane.showMessageDialog(panel, "Imagen guardada con éxito.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(panel, "Error al guardar la imagen: " + ex.getMessage());
            }
        }
    }
}
</code></pre>

<h3>Explicación del Código</h3>
<li>Pueden visitar el siguiente video: https://youtu.be/xAkmzjIWtPI</li>

<h4>Paquete y Importaciones</h4>
<pre><code>package panelpng;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
</code></pre>
<ul>
    <li>Define el paquete <code>panelpng</code> y realiza las importaciones necesarias para manejar gráficos, imágenes, archivos y componentes de Swing.</li>
</ul>

<h4>Clase <code>GuardarPanelComoImagen</code></h4>
<pre><code>public class GuardarPanelComoImagen {
</code></pre>
<ul>
    <li>Declara una clase pública llamada <code>GuardarPanelComoImagen</code>.</li>
</ul>

<h4>Método <code>guardarPanelComoImagen</code></h4>
<pre><code>public static void guardarPanelComoImagen(JPanel panel) {
</code></pre>
<ul>
    <li>Declara un método estático que toma un <code>JPanel</code> como parámetro.</li>
</ul>

<h4>Creación de la Imagen</h4>
<pre><code>BufferedImage imagen = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g2 = imagen.createGraphics();
panel.paint(g2);
g2.dispose();
</code></pre>
<ul>
    <li>Crea una imagen en memoria del tamaño del <code>JPanel</code> con un tipo de color RGB.</li>
    <li>Obtiene un contexto gráfico de la imagen.</li>
    <li>Dibuja el contenido del <code>JPanel</code> en la imagen.</li>
    <li>Libera los recursos asociados con el contexto gráfico para evitar fugas de memoria.</li>
</ul>

<h4>Selección del Archivo</h4>
<pre><code>JFileChooser selectorArchivo = new JFileChooser();
if (selectorArchivo.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION) {
    File archivo = selectorArchivo.getSelectedFile();
    if (!archivo.getAbsolutePath().endsWith(".png")) {
        archivo = new File(archivo + ".png");
    }
</code></pre>
<ul>
    <li>Crea un selector de archivos.</li>
    <li>Abre un cuadro de diálogo para seleccionar un archivo y verifica si el usuario ha aprobado la selección.</li>
    <li>Obtiene el archivo seleccionado por el usuario.</li>
    <li>Verifica si el archivo tiene la extensión ".png" y, si no la tiene, la agrega automáticamente.</li>
</ul>

<h4>Guardado de la Imagen</h4>
<pre><code>try {
    ImageIO.write(imagen, "png", archivo);
    JOptionPane.showMessageDialog(panel, "Imagen guardada con éxito.");
} catch (IOException ex) {
    JOptionPane.showMessageDialog(panel, "Error al guardar la imagen: " + ex.getMessage());
}
</code></pre>
<ul>
    <li>Intenta guardar la imagen en el archivo seleccionado en formato PNG.</li>
    <li>Muestra un mensaje indicando que la imagen se ha guardado con éxito.</li>
    <li>Si ocurre un error, muestra un mensaje indicando que ocurrió un error al guardar la imagen.</li>
</ul>

<h2>Instalación</h2>
<p>Para utilizar este componente en tu proyecto, sigue estos pasos:</p>
<ol>
    <li>Clona el repositorio con el siguiente comando:
        <pre><code>git clone https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen.git</code></pre>
    </li>
    <img src="https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen/blob/master/Caps/Captura%20de%20pantalla%202024-07-21%20a%20la(s)%201.29.22%E2%80%AFp.m..png" alt="Clonar el repositorio" style="max-width: 100%;">
    </li>
    <li>Importa el proyecto en tu IDE preferido (NetBeans o IntelliJ IDEA).</li>
    <li>Asegúrate de que el proyecto se compila sin errores.</li>
</ol>

<h2>Uso</h2>
<p>Para usar el componente en tu aplicación, sigue estos pasos:</p>
<ol>
    <li>Agrega el componente a tu proyecto.</li>
    <li>Dar click derecho en la paleta y palette manager</li>
    <img src="https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen/blob/master/Caps/Captura%20de%20pantalla%202024-07-21%20a%20la(s)%201.30.55%E2%80%AFp.m..png" style="max-width: 100%;">
    <li>Despues dar click en Add from JAR</li>
    <img src="https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen/blob/master/Caps/Captura%20de%20pantalla%202024-07-21%20a%20la(s)%201.31.05%E2%80%AFp.m..png" style="max-width: 100%;">
    <li>Buscamos en donde se guarde nuestro JAR y damos next</li>
     <img src="https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen/blob/master/Caps/Captura%20de%20pantalla%202024-07-21%20a%20la(s)%201.31.46%E2%80%AFp.m..png" style="max-width: 100%;">
    <li>Seleccionamos el componente GuardarPanelComoImagen y next</li>
     <img src="https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen/blob/master/Caps/Captura%20de%20pantalla%202024-07-21%20a%20la(s)%201.34.23%E2%80%AFp.m..png" style="max-width: 100%;">
    <li>Seleccionamos en que carpeta de la paleta podemos en componente y finish </li>
    <img src="https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen/blob/master/Caps/Captura%20de%20pantalla%202024-07-21%20a%20la(s)%201.34.43%E2%80%AFp.m..png" style="max-width: 100%;">
    <li>EL componente nos saldra en la paleta se la siguiente forma: </li>
    <img src="https://github.com/GiovanyRaymundoOC/ito_tap_u2_componente_Panelimagen/blob/master/Caps/Captura%20de%20pantalla%202024-07-21%20a%20la(s)%201.53.33%E2%80%AFp.m..png" style="max-width: 100%;">
    <li>Llama al método <code>guardarPanelComoImagen</code> y pásale el <code>JPanel</code> que deseas guardar como imagen.</li>
</ol>

<p>Ejemplo:</p>
<pre><code>JPanel miPanel = new JPanel();
// Agregar componentes y configuración al panel

GuardarPanelComoImagen.guardarPanelComoImagen(miPanel);
</code></pre>

<p>Esto abrirá un cuadro de diálogo para que el usuario seleccione dónde guardar la imagen del panel. Si el usuario no proporciona la extensión ".png", el método la agregará automáticamente.</p>

<h2>Manejo de Errores Comunes</h2>
<p>Si experimentas problemas de incompatibilidad de versiones al desarrollar y ejecutar el programa en diferentes entornos de desarrollo o ejecución de Java, asegúrate de:</p>
<ol>
    <li>Seleccionar la opción "Resolve Project Problems" en tu IDE y seguir las instrucciones para resolver cualquier problema.</li>
    <li>Ajustar la configuración del proyecto para ser compatible con la versión de Java que estás utilizando.</li>
</ol>
<h2>Autores</h2>
<p>Ortiz Martinez Jose Julian
<p>Olmedo Carbajal Giovany Raymundo --> https://github.com/GiovanyRaymundoOC </p>

</body>
</
