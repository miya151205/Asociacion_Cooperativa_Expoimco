# Instrucciones para añadir el logo del cliente

Recomendación de ubicación y formato:

- Ruta recomendada: `docs/logo.png` o `docs/logo.svg`.
- Tamaño sugerido (PNG): 280×80 px (proporción apaisada). Para un resultado escalable usar SVG.
- Nombre de archivo: `logo.png` o `logo.svg`.

Cómo añadirlo:
1. Coloca el archivo `logo.png` en la carpeta `docs/`.
2. Asegúrate de commitear el archivo al repositorio:
   ```bash
   git add docs/logo.png
   git commit -m "chore: add client logo"
   git push origin <tu-rama>
   ```

Nota: Si prefieres no almacenar el logo en el repositorio (por razones legales o de privacidad), puedes usar una URL externa y actualizar `README.md` para apuntar a esa URL en lugar de `/docs/logo.png`.
