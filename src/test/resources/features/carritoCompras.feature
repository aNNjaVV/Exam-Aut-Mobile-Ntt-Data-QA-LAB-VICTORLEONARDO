@General
Feature: Examen - Validar funcionalidad del carrito de compras

  @Principal
  Scenario Outline: Agregar productos al carrito y validar actualización del carrito de compras
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galería
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                 | UNIDADES |
      | Sauce Labs Backpack      | 1        |
      | Sauce Labs Bolt T-Shirt  | 1        |
      | Sauce Labs Bike Light    | 2       |

    #EL TERCER PRODUCTO, NO FUNCIONA SE CAE LA APLICACIÓN uu
    #EL 2DO LE MANDO 1 UNIDAD Y TE LO TOMA COMO 10 uu
    #EL PRIMERO FUNCIONA CON NORMALIDAD
