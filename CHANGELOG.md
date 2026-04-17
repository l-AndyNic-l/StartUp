# Changelog

Todos los cambios notables de este proyecto serán documentados en este archivo.

---

## [v0.5.3] - 17-04-2026

### Added
- Se añadieron las nuevas funciones a la capa "TrabajadorController".

## [v0.5.2] - 17-04-2026

### Added
- Se añadieron las consultas personalizadas a la base de datos en la capa "TrabajadorRepository".
- Se añadieron las funciones que manejan las nuevas consultas en la capa "Trabajador Service".

## [v0.4.2] - 17-04-2026
### Added
- Se añadió endpoint (DeleteMapping) al controlador "DepartamentoController".
- Se añadieron endpoints estandares al controlador "TrabajadorController".

## [v0.4.1] - 17-04-2026
### Changed
- Se redefinieron las validaciones de la tabla "Departamento" en el modelo del proyecto.
- Se definió la clase "DepartamentoDTO" en el directorio "dto" del proyecto.


## [v0.4.0] - 17-04-2026

### Added
- Se añadieron las reglas de negocio en el servicio "Trabajador".
- Se añadieron los datos en la capa "TrabajadorDTO".

### Changed
- Se definió el repositorio "TrabajadorRepository" en el repositorio del proyecto.
- Se definió el servicio "TrabajadorService" en el servicio del proyecto.
- Se definió la capa  "TrabajadorDTO" en el dto del proyecto.

## [v0.3.0] - 16-04-2026

### Added
- Se añadieron los datos en la clase "Trabajador".
- Se añadieron las reglas de negocio en la clase "Trabajador".
- Se añadio el nombre del proyecto en el documento poperties.
- Se añadio el nombre de la base de datos en el documento properties.

### Changed
- Se definió la clase "Trabajador" en el modelo del proyecto.

## [v0.2.0] - 16-04-2026

### Added
- Se añadieron las reglas de negocio en el servicio "DepartamentoService".
- Se añadieron funciones básicas CRUD en el controlador "DepartamentoController".

### Changed
- Se definió la clase "Departamento" en el modelo del proyecto.
- Se definió el repositorio "DepartamentoRepository" en el repositorio del proyecto.
- Se definió el servicio "DepartamentoService" en el servicio del proyecto.
- Se definió el controlador "DepartamentoControlador" en el controlador del proyecto.
- Se establecieron las bases para la conexión a MySQL en "application.properties".

## [v0.1.0] - 16-04-2026

### Added
- Se añadieron los directorios relacionados al CSRM (Controller-Service-Repository-Model).
- Se añadieron las clases e interfaces relacionados al CSRM.
- Se añadieron los directorios DTO para las clases correspondientes al modelo del proyecto.
