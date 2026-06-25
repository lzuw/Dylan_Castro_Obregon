# TiendaApp — Resumen Clases 1 a 4

App Spring Boot completa de **inventario de productos** que integra todo lo visto en las primeras 4 clases del curso SC-403.

## ✅ Tecnologías integradas

| Clase | Tema | Implementación |
|---|---|---|
| 1 | Git y GitHub | `.gitignore`, commits convencionales, branches por feature |
| 2 | Spring Boot + MVC + HTTP | Controllers con `@GetMapping`, `Model`, vistas Thymeleaf |
| 3 | Thymeleaf + Bootstrap 5 | Fragments reutilizables, grid responsive, `th:each` |
| 4 | MySQL + JPA + Hibernate | Entity, Repository, Service, MVC completo, DI con `@Autowired` |

## 🗂️ Estructura

```
tiendaapp/
├── pom.xml                                  ← deps: web, thymeleaf, jpa, mysql
├── seed-data.sql                            ← 10 productos de ejemplo
├── postman-collection.json                  ← peticiones para testear
├── README.md                                ← este archivo
├── .gitignore
└── src/main/
    ├── java/com/ufide/tiendaapp/
    │   ├── TiendaappApplication.java        ← main (root)
    │   ├── controller/                       Capa Controller
    │   │   ├── HomeController.java
    │   │   └── ProductoController.java
    │   ├── entity/                           Capa Entity
    │   │   └── Producto.java
    │   ├── repository/                       Capa Repository
    │   │   └── ProductoRepository.java
    │   └── service/                          Capa Service
    │       └── ProductoService.java
    └── resources/
        ├── application.properties           ← config + vars de entorno
        ├── static/css/styles.css
        └── templates/
            ├── home.html
            ├── productos.html               ← grid responsive con filtros
            ├── producto.html                ← detalle con breadcrumb
            └── fragments/header.html        ← navbar + footer
```

## 🚀 Cómo correr

### 1. Tener MySQL corriendo

Crear la base de datos en Workbench:
```sql
CREATE DATABASE tiendadb CHARACTER SET utf8mb4;
```

### 2. Configurar las credenciales

Por defecto la app usa:
- URL: `jdbc:mysql://localhost:3306/tiendadb`
- Usuario: `root`
- Password: `cambiame_local`

Para usar TUS credenciales sin modificar el `application.properties`, definí variables de entorno:

**Windows (PowerShell, solo esa sesión):**
```powershell
$env:DB_PASSWORD = "tupassword"
.\mvnw.cmd spring-boot:run
```

**Windows (CMD):**
```cmd
set DB_PASSWORD=tupassword
mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
export DB_PASSWORD=tupassword
./mvnw spring-boot:run
```

### 3. Arrancar la app

```bash
mvnw.cmd spring-boot:run        # Windows
./mvnw spring-boot:run          # Linux/Mac
```

O desde VS Code: clic derecho en `TiendaappApplication.java` → Run.

### 4. Cargar los productos de ejemplo

En MySQL Workbench:
- **File → Open SQL Script** → seleccionar `seed-data.sql` → Execute (rayo).

### 5. Abrir el navegador

- `http://localhost:8080` — Página inicial con stats
- `http://localhost:8080/productos` — Listado
- `http://localhost:8080/productos/1` — Detalle
- `http://localhost:8080/productos?buscar=laptop` — Búsqueda
- `http://localhost:8080/productos/bajo-stock` — Filtro

## 🧪 Testing con Postman

1. Abrir Postman → File → Import → `postman-collection.json`.
2. Ejecutar las peticiones de la colección.
3. Verificar: status codes, body HTML, tiempos.

## 🌳 Workflow Git sugerido

Este proyecto se desarrolló con un workflow de branches:

```bash
# branches por feature
git checkout -b feature/setup-mysql
# ... cambios ...
git add .
git commit -m "feat: configurar conexion MySQL con variables de entorno"
git checkout main
git merge --no-ff feature/setup-mysql

git checkout -b feature/entity-producto
# ... cambios ...
git commit -m "feat: agregar Entity Producto con anotaciones JPA"

git checkout -b feature/repository-service
git commit -m "feat: agregar ProductoRepository y ProductoService"

git checkout -b feature/views-bootstrap
git commit -m "feat: implementar vistas con Bootstrap y fragments"

# tag de release
git tag -a v1.0 -m "Resumen Clases 1 a 4 completo"
git push origin main --tags
```

Ver el laboratorio paso a paso para el detalle del flujo.

## 🔗 Recursos

- **Spring Boot Docs:** https://docs.spring.io/spring-boot/reference/
- **Spring Data JPA:** https://docs.spring.io/spring-data/jpa/reference/
- **Thymeleaf:** https://www.thymeleaf.org/documentation.html
- **Bootstrap 5:** https://getbootstrap.com/docs/5.3
- **MySQL Workbench:** https://dev.mysql.com/downloads/workbench/

## 🆘 Problemas comunes

| Síntoma | Solución |
|---|---|
| `Access denied for user 'root'` | Verificar `DB_PASSWORD` o el default en `application.properties`. |
| `Unknown database 'tiendadb'` | `CREATE DATABASE tiendadb;` en Workbench. |
| `Table 'productos' doesn't exist` | Hibernate la crea al arrancar. Si falla, verificar `ddl-auto=update`. |
| Página `/productos` vacía | Ejecutar `seed-data.sql` en Workbench. |
| Cambios en HTML no se ven | `spring.thymeleaf.cache=false` ya está activo. Refrescar el navegador. |
| Puerto 8080 en uso | Cambiar `server.port=8081` o matar el proceso anterior. |
