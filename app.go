package main

import (
	"fmt"
	"html/template"
	"net/http"
)

type Usuarios struct {
	// Debe ser con mayúscula para ser exportado
	Name  string
	Skill string
	Edad  int
}

func Index(rw http.ResponseWriter, r *http.Request) {
	template, err := template.ParseFiles("templates/index.html")
	if err != nil {
		panic(err)
	}
	usuario := Usuarios{"matias", "desarrollador", 23}
	// Ejecutar el template una sola vez después de verificar errores
	err = template.Execute(rw, usuario)
	if err != nil {
		http.Error(rw, err.Error(), http.StatusInternalServerError)
	}
}

func main() {
	http.HandleFunc("/", Index)
	// Crea el servidor
	fmt.Println("El servidor está corriendo en el puerto 3000")
	fmt.Println("Run server: http://localhost:3000")
	http.ListenAndServe(":3000", nil)
}
