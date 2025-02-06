package com.nttdata.steps;

import com.nttdata.screens.CarritoScreen;
import org.junit.Assert;
import java.time.Duration;
import java.util.List;

public class CarritoComprasSteps {

    //Private CarritoScreen carritoScreen;
    CarritoScreen carritoScreen;

    public void validarSesion() {
        try {
            Assert.assertTrue(carritoScreen.elTituloExiste());
        } catch (AssertionError e) {
            System.out.println("ERROR EN ETAPA DE STEPS - SESION");

        }
    }

    public void validarListaDeProductosEnPantalla() {
        try {
            Assert.assertTrue(carritoScreen.listaDeProductosEnPantalla());
        } catch (AssertionError e) {
            System.out.println("ERROR EN ETAPA DE STEPS - LISTA PRODUCTOS");

        }
    }
 //---------------------FIN ETAPA 1 -----------------------//

    public void seleccionarCantidad(int cantidad) {
        if (cantidad < 1) {System.out.println("ERROR EN ETAPA DE STEPS: La cantidad seleccionada no puede ser menor a 1.");return;}
        try {for (int i = 1; i < cantidad; i++) {carritoScreen.seleccionarLaCantidad();}
            agregarProductoAlCarrito();
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE STEPS - SELECCIÓN DE CANTIDAD: " + e.getMessage());
        }
    }

    public void buscarProducto(String productName) {
        try {
            carritoScreen.escogerProducto(productName);
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE STEPS - BÚSQUEDA DE PRODUCTO: " + productName);
        }
    }

    public void agregarProductoAlCarrito() {
        try {
            carritoScreen.agregarAlCarrito();
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE STEPS - AGREGAR PRODUCTO AL CARRITO: " + e.getMessage());
        }
    }
    //---------------------FIN ETAPA 2--------------------------//

    public void irAlCarritoDeCompras() {
        try {
            carritoScreen.irAlCarritoDeCompras();
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE STEPS - NAVEGACIÓN AL CARRITO DE COMPRAS: " + e.getMessage());
        }
    }

    public void validarProductosEnCarrito() {
        try {
            Assert.assertTrue(carritoScreen.productosEnCarritoDeCompras());
        } catch (AssertionError e) {
            System.out.println("ERROR EN ETAPA DE STEPS - VALIDACIÓN DE PRODUCTOS EN CARRITO: " + e.getMessage());
        }
    }

    //---------------------FIN ETAPA 3 -----------------------//
      /*}
     private void verificarCondicion(boolean condicion, String mensajeError) {
        try {
            Assert.assertTrue(condicion);
        } catch (AssertionError e) {
            System.out.println("ERROR EN ETAPA DE STEPS - " + mensajeError + ": " + e.getMessage());
        }
    }

    public void ejecutarAccionConControl(Runnable accion, String mensajeError) {
    try {
        accion.run();
    } catch (AssertionError e) {
        System.out.println("ASSERTION ERROR EN ETAPA DE STEPS - " + mensajeError + ": " + e.getMessage());
    } catch (Exception e) {
        System.out.println("ERROR EN ETAPA DE STEPS - " + mensajeError + ": " + e.getMessage());
    }
}


     */




}