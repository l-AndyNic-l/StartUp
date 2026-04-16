# StartUp
Desarrollo de API REST con Spring Boot
1. Contexto del Proyecto
  Se requiere desarrollar un sistema de gestión interna para una empresa que permita administrar su capital humano organizado por departamentos.
  El sistema debe ser construido utilizando Java 21 (o superior) y Spring Boot, integrando persistencia en MySQL.

2. Stack Tecnológico Requerido
  El proyecto debe incluir las siguientes dependencias en el pom.xml:
    Spring Web: Para la creación de controladores y servicios REST.
    Spring Data JPA: Para la persistencia y mapeo objeto-relacional.
    MySQL Driver: Conector para la base de datos.
    Validation: Para la aplicación de restricciones y reglas de negocio en los modelos.
    Lombok: Para reducir el código repetitivo (Boilerplate).

3. Modelo de Datos y Reglas de Negocio
  A. Entidad Departamento
    Código de Departamento: String. Debe ser la Primary Key. Restricción: Exactamente 4 caracteres.
    Nombre: String. Obligatorio.
    Descripción: String. Opcional.
   
  B. Entidad Trabajador
    ID: Long. Autoincremental.
    Nombre: String. Obligatorio.
    Apellido: String. Obligatorio.
    Email: String. Obligatorio, debe tener formato de correo válido y ser único.
    Fecha de Contrato: LocalDate. Obligatorio.
    Especialidad: Solo se permiten: Desarrollo, Administración o Testing.
    Sueldo: Integer. No puede ser negativo.
    Carga Familiar: Integer. Valor por defecto 0 si no se ingresa.
    Departamento: Relación ManyToOne con la entidad Departamento.
    
5. Capa de Transferencia de Datos (DTO)
  Para proteger la integridad del modelo y optimizar las respuestas, se debe implementar un TrabajadorDTO con la siguiente estructura calculada:
    ID: Identificador único.
    Nombre Completo: Concatenación de Nombre y Apellido.
    Tiempo de Experiencia: String que indique años y meses (Ej: "2 años y 4 meses") calculado desde la FechaContrato hasta hoy.
    Sueldo: Sueldo del trabajador.
    Especialidad: Especialidad del trabajador.
    Nombre Departamento: Mostrar solo el nombre del departamento al que pertenece.
   
6. Requerimientos Funcionales (Endpoints)
  Como base debe crear los endpoint básicos para listar todos, listar por id y registrar.
  Además debe añadir los siguientes métodos:

    Endpoints de Trabajador: Deben implementarse en el TrabajadorController consumiendo lógica del TrabajadorService:
      Búsqueda por Email: Obtener un trabajador único.
      Filtrar por Especialidad: Retornar lista de trabajadores de un área específica.
      Rango Salarial:
      Trabajadores con sueldo mayor a $X.
      Trabajadores con sueldo menor a $Y.
      Trabajadores con sueldo entre $A y $B (Usar @RequestParam).
      Pertenece a Departamento: Lista de trabajadores según el código de departamento.
      Experiencia Exacta: Trabajadores que tengan exactamente X años de antigüedad.
      Costo de Planilla: Dado un código de departamento, calcular la sumatoria total de los sueldos de todos los trabajadores pertenecientes a él.
