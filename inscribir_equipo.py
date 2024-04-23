from fastapi import FastAPI, Form
from reactpy import component, html
from reactpy.backend.fastapi import configure
import psycopg2

# Configuración de la conexión a la base de datos PostgreSQL
conn = psycopg2.connect(
    dbname="postgres",
    user="postgres",
    password="123456",
    host="localhost"
)

app = FastAPI()

@component
def AddPlayerForm():
    return html.form(
        {"method": "post", "onSubmit": "return handleSubmit(event)"},
        html.input({"name": "Jug_numero", "placeholder": "Número del jugador", "type": "text", "style": "margin-bottom: 10px;"}),
        html.input({"name": "Jug_nombre", "placeholder": "Nombre del jugador", "type": "text", "style": "margin-bottom: 10px;"}),
        html.input({"type": "submit", "value": "Enviar", 
                    "style": "background-color: #4CAF50; color: white; padding: 10px 20px; border: none; cursor: pointer; border-radius: 5px;"})
    )

@component
def App():
    return html.div(
        html.h1({"style": "font-size: 54px; text-align: center;"}, "Agregar nuevo jugador"),
        html.div(
            AddPlayerForm()
        ),
        html.script(
            """
            function handleSubmit(event) {
                event.preventDefault();
                // Realizar la lógica de envío de datos aquí, si es necesario
                // Después, redirige al mismo sitio
                window.location.href = window.location.href;
            }
            """
        ),
        html.style(
            """
            body {
                font-family: Arial, sans-serif;
            }
            """
        )
    )

# Ruta para manejar el formulario de inserción de nuevos jugadores
@app.post("/")
async def add_player(Jug_numero: str = Form(...), Jug_nombre: str = Form(...)):
    cursor = conn.cursor()
    query = "INSERT INTO Jugadores (Jug_numero, Jug_nombre) VALUES (%s, %s)"
    cursor.execute(query, (Jug_numero, Jug_nombre))
    conn.commit()
    cursor.close()
    return {"message": "¡Nuevo jugador agregado correctamente!"}

configure(app, App)
