BEGIN;

-- Agregar la columna isActivo
ALTER TABLE medico
ADD COLUMN isActivo BOOLEAN;

-- Actualizar todos los registros para establecer isActivo en true
UPDATE medico SET isActivo = true;

COMMIT;
