package com.nttdata.stepsdefinition;

import com.nttdata.steps.CarritoComprasSteps;
import net.serenitybdd.annotations.Steps;
import io.cucumber.java.en.*;

public class CarritoComprasStepsDefinition {
    @Steps
    CarritoComprasSteps carritoComprasSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicación_de_sauce_labs() {
        try {
            carritoComprasSteps.validarSesion();
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE GIVEN (DEFINITIONS) - VALIDACIÓN DE SESIÓN: " + e.getMessage());
        }
    }

    @Given("valido que carguen correctamente los productos en la galería")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
        try {
            carritoComprasSteps.validarListaDeProductosEnPantalla();
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE GIVEN (DEFINITIONS) - VALIDACIÓN DE LISTA DE PRODUCTOS EN PANTALLA: " + e.getMessage());
        }
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(int quantity, String productName) {
        try {
            carritoComprasSteps.buscarProducto(productName);
            carritoComprasSteps.seleccionarCantidad(quantity);
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE WHEN (DEFINITIONS) - AGREGAR PRODUCTO AL CARRITO: " + e.getMessage());
        }
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void valido_el_carrito_de_compra_actualice_correctamente() {
        try {
            carritoComprasSteps.irAlCarritoDeCompras();
            carritoComprasSteps.validarProductosEnCarrito();
        } catch (Exception e) {
            System.out.println("ERROR EN ETAPA DE THEN (DEFINITIONS) - VALIDACIÓN DEL CARRITO DE COMPRAS: " + e.getMessage());
        }
    }
}
