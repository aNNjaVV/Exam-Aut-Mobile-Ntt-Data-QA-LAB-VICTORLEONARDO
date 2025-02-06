package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarritoScreen extends PageObject {

    //DECLARAMOS TODOS LOS XPATH Y BYID, de las pantallas que utilizaremos.
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV") private WebElement listaProductos;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV") private WebElement iconoCarrito;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV") private WebElement btnIncrementar;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt") private WebElement btnAgregar;
    //@AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/mTvTitle") private WebElement titulo; //SE INTENTO FULL ID, PERO ENTRABA EN CONFLICO AQUI
    // @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV") private WebElement contenedor; //SE INTENTO FULL ID, PERO ENTRABA EN CONFLICO AQUI
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='App logo and name']") private WebElement titulo;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']") private WebElement contenedor;


    private void metodoGenericoDeEspera(WebElement elemento) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(elemento));
    }

    public boolean elTituloExiste() {
        try {
            metodoGenericoDeEspera(titulo);
            return titulo.isDisplayed();
        } catch (Exception e) {
            System.err.println("NO SE ENCONTRO EL TITULO :" + e.getMessage() + " (ETAPA DE SCREENS)");
            return false;
        }
    }

    public boolean listaDeProductosEnPantalla() {
        try {
            metodoGenericoDeEspera(listaProductos);
            return listaProductos.isDisplayed();
        } catch (Exception e) {
            System.err.println("NO SE ENCONTRÓ LA LISTA DE PRODUCTOS: " + e.getMessage() + " (ETAPA DE SCREENS)");
            return false;
        }
    }

    public void escogerProducto(String nombreProducto) {
        WebDriverWait tiempoDeEsperaControlado = new WebDriverWait(getDriver(), Duration.ofMillis(3000));
        try {
            metodoGenericoDeEspera(contenedor);
            List<WebElement> productos1 = contenedor.findElements(By.xpath(".//android.widget.TextView"));
            for (int pr = 1; pr <= productos1.size(); pr++) {
                WebElement producto1 = tiempoDeEsperaControlado.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(String.format("//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup[%d]", pr))));
                List<WebElement> nombre = producto1.findElements(By.id("com.saucelabs.mydemoapp.android:id/titleTV"));
                if (!nombre.isEmpty() && nombre.get(0).getText().equalsIgnoreCase(nombreProducto)) {
                    tiempoDeEsperaControlado.until(ExpectedConditions.elementToBeClickable(producto1)).click();
                    return;}}} catch (Exception ignored) {}
    }


    public void seleccionarLaCantidad() {
        try {
            metodoGenericoDeEspera(btnIncrementar);
            btnIncrementar.click();
        } catch (Exception e) {
            System.err.println("NO FUE POSIBLE SELECCIONAR" + e.getMessage() + " (ETAPA DE SCREENS)");
        }
    }

    public void agregarAlCarrito() {
        try {
            metodoGenericoDeEspera(btnAgregar);
            btnAgregar.click();
        } catch (Exception e) {
            System.err.println("NO SE PUDO AGREGAR AL CARRITO: " + e.getMessage() + " (ETAPA DE SCREENS)");
        }
    }


    public void irAlCarritoDeCompras() {
        try {
            metodoGenericoDeEspera(iconoCarrito);
            iconoCarrito.click();
        } catch (Exception e) {
            System.err.println("ERROR AL INTENTAR IR AL CARRITO DE COMPRAS: " + e.getMessage() + " (ETAPA DE SCREENS)");
        }
    }

    public boolean productosEnCarritoDeCompras() {
        try {
            metodoGenericoDeEspera(listaProductos);
            return listaProductos.isDisplayed();
        } catch (Exception e) {
            System.err.println("ERROR AL VALIDA PRODUCTOS EN CARRITO: " + e.getMessage() + " (ETAPA DE SCREENS)");
            return false;
        }
    }

}
