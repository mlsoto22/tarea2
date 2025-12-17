 NOMBRE DEL PROYECTO: NotesApp
 DESCRIPCIÓN:
 Aplicación con la finalidad de crear, editar y eliminar notas además de categorias.

  INSTALACIÓN Y EJECUCIÓN
-Copia el repositorio
-Abrir en Android Studio
-Clonar repositorio
-Ejecutar la app

  
com.fic.notesapp/
├── controller/       # Lógica de negocio y acceso a datos
│   ├── CategoryController.java
│   └── NoteController.java
├── db/               # Clases relacionadas con la base de datos│   └── DBHelper.java
├── model/            # Clases de datos (POJOs)
│   ├── category/
│   │   └── Category.java
│   └── note/
│       └── Note.java
└── view/             # Activities, Adapters y ViewHolders
    ├── category/
    │   ├── CategoryAdapter.java
    │   └── CategoryViewHolder.java
    ├── note/
    │   ├── NoteAdapter.java
    │   └── NoteViewHolder.java
    ├── AddNotesActivity.java
    └── MainActivity.java


ESTRUCTURA DE LA BASE DE DATOS
CREATE TABLE category (
    category_id INTEGER PRIMARY KEY AUTOINCREMENT,
    category_name TEXT NOT NULL
);

CREATE TABLE note (
    note_id INTEGER PRIMARY KEY AUTOINCREMENT,
    category_id INTEGER NOT NULL,
    note_title TEXT NOT NULL,
    note_content TEXT,
    created_at TEXT,
    FOREIGN KEY (category_id) REFERENCES category(category_id) ON DELETE CASCADE
);

INTERFACES DE USUARIO

<img width="540" height="1144" alt="Captura de pantalla 2025-12-16 205709" src="https://github.com/user-attachments/assets/64a34a80-4a2d-4b57-8ba4-10e4606d947a" />
<img width="514" height="1118" alt="Captura de pantalla 2025-12-16 205745" src="https://github.com/user-attachments/assets/7a440531-bf70-4958-a69f-5bb7fddc343e" />
<img width="516" height="1122" alt="Captura de pantalla 2025-12-16 205918" src="https://github.com/user-attachments/assets/2e750f3a-0286-4564-a266-5006347930a8" />




