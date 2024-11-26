# Sistema de Gestión de Franquicias

## Descripción
Este proyecto es una aplicación para gestionar franquicias, sucursales y productos. Permite crear y listar franquicias, sucursales asociadas a franquicias, y gestionar productos en diferentes sucursales.

## Características Principales

### Franquicias
- **Crear Franquicia**
  - Método: POST
  - Endpoint: `http://localhost:8080/api/franchise`
  - Ejemplo de Body:
    ```json
    {
        "name": "Cali"
    }
    ```

- **Listar Franquicias**
  - Método: GET
  - Endpoint: `http://localhost:8080/api/franchise`
  - Respuesta de ejemplo:
    ```json
    [
        {
            "id": "67461eb132152f179885df5d",
            "name": "Centro"
        },
        {
            "id": "67462cb65c7a661a250c2b7a",
            "name": "Bogota"
        }
    ]
    ```

### Sucursales
- **Crear Sucursal**
  - Método: POST
  - Endpoint: `http://localhost:8080/api/branch-office`
  - Ejemplo de Body:
    ```json
    {
        "name": "test",
        "franchise_id": "67462cc15c7a661a250c2b7c"
    }
    ```

- **Listar Sucursales**
  - Método: GET
  - Endpoint: `http://localhost:8080/api/branch-office`
  - Respuesta de ejemplo:
    ```json
    [
        {
            "id": "67462d565c7a661a250c2b87",
            "name": "Cali Oriente",
            "franchiseResponse": {
                "id": "67462cc15c7a661a250c2b7c",
                "name": "Cali"
            }
        }
    ]
    ```

### Productos
- **Crear Producto**
  - Método: POST
  - Endpoint: `http://localhost:8080/api/product`
  - Ejemplo de Body:
    ```json
    {
        "branch-office-id": "67462cfa5c7a661a250c2b7d",
        "name": "Coca Cola"
    }
    ```

- **Listar Productos**
  - Método: GET
  - Endpoint: `http://localhost:8080/api/product`
  - Respuesta de ejemplo:
    ```json
    [
        {
            "id": "6746344ced34071365e49931",
            "name": "Coca Cola",
            "stock": 0,
            "branchOffice": {
                "id": "67462d4a5c7a661a250c2b85",
                "name": "Cali Sur"
            }
        }
    ]
    ```

- **Eliminar Producto**
  - Método: DELETE
  - Endpoint: `http://localhost:8080/api/product/{id-product}`

- **Actualizar Stock de Producto**
  - Método: PUT
  - Endpoint: `http://localhost:8080/api/product/{product-id}`
  - Respuesta de ejemplo:
    ```json
    {
        "id": "67462dcb5c7a661a250c2b89",
        "name": "Coca Cola",
        "stock": 100,
        "branchOffice": {
            "id": "67462cfa5c7a661a250c2b7d",
            "name": "Bogota Norte"
        }
    }
    ```

- **Obtener Producto Más Vendido por Franquicia**
  - Método: GET
  - Endpoint: `http://localhost:8080/api/product/{franquisia-id}`
  - Respuesta de ejemplo:
    ```json
    [
        {
            "id": "67462d4a5c7a661a250c2b85",
            "name": "Cali Sur",
            "product": null
        },
        {
            "id": "67462d5c5c7a661a250c2b88",
            "name": "Cali Occidente",
            "product": {
                "id": "6746344ced34071365e49931", 
                "name": "Coca Cola", 
                "stock": 100
            }
        }
    ]
    ```

## Requisitos
- Java 17+
- Spring Boot
- MongoDB
- Docker (opcional)

## Configuración

### Ejecución con Docker
Para ejecutar la aplicación usando Docker:

```bash
docker-compose up -d --build
```

Este comando levantará la aplicación y sus dependencias (como MongoDB) en contenedores.

## Tecnologías Utilizadas
- Spring Boot
- Spring Data MongoDB
- Maven
- Docker

## Contribución
Por favor, lee las directrices de contribución antes de enviar un pull request.

## Licencia
[Especificar la licencia]