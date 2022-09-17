const URL_API = "http://localhost:8080/mascotas"

async function get_mascotas(){
    // Enviar una peticion
    const resp = await fetch(URL_API)
    // Obtener datos de la peticion
    const mascotas = await resp.json()

    return mascotas
}

console.log(get_mascotas())