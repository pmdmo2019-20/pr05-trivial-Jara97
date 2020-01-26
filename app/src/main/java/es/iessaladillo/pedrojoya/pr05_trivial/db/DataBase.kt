package es.iessaladillo.pedrojoya.pr05_trivial.db

private val questions:List<Question> =
    listOf(
        Question("¿Cual es el nombre completo de Baldomero Espartero?",
            listOf<Answer>(Answer("Joaquín Baldomero Fernández-Espartero Álvarez de Toro",true),Answer("Baldomero Llegate Ligero",false),
                Answer("Daniel",false),Answer("Jose Baldomero Espartero",false))),
        Question("¿Cual es la asignatura favorita del creador de esta aplicación?",
            listOf<Answer>(Answer("Desarrollo de interfaces",false),Answer("Desarrollo de interfaces",false),
                Answer("Desarrollo de interfaces",false),Answer("Ninguna de las anteriores",true))),
        Question("¿Donde tuvo lugar la Guerra del Peloponeso?",
            listOf<Answer>(Answer("Roma",false),Answer("La antigua Grecia",true),
                Answer("Australia",false),Answer("Detrás tuya",false))),
        Question("¿Como se conoce popularmente a Geralt de Rivia?",
            listOf<Answer>(Answer("El Brujero",false),Answer("El Magias",false),
                Answer("Gerardo de Revilla y su caballo Maravilla",false),Answer("Todas las anteriores son correctas",true))),
        Question("Why are we still here",
            listOf<Answer>(Answer("just to suffer",true),Answer("just to consume",false),
                Answer("just to be happy",false),Answer("just to fight",false))),
        Question("¿En que año se descubrió la penicilina?",
            listOf<Answer>(Answer("1945",false),Answer("1928",true),
                Answer("1889",false),Answer("1902",false))),
        Question("¿Que necesita Boguez para jugar Mordekaiser",
            listOf<Answer>(Answer("2 Manos",false),Answer("Un Cerebro",false),
                Answer("Una perfecta coordinación en sus movimientos",false),Answer("Un respiradero",true))),
        Question("Cual es el animal preferido de Boguez",
            listOf<Answer>(Answer("Gato",false),Answer("Perro",false),
                Answer("Leopardo",false),Answer("Limpiafondos",true))),
        Question("Cual es el nombre del piloto del Báron rojo",
            listOf<Answer>(Answer("Roy Brown",false),Answer("Lanoe Hawker",false),
                Answer("Manfred Albrecht Freiherr von Richthofen",true),Answer("Francisco Fernando de Austria",false))),
        Question("Cual es el objetivo en la vida de Naruto",
            listOf<Answer>(Answer("Ser hokage",true),Answer("Ser un ninja",false),
                Answer("Recorrer el mundo",false),Answer("Ser el rey de los piratas",false))),
        Question("En que año nació Ricardo Milos",
            listOf<Answer>(Answer("1456",false),Answer("2001",false),
                Answer("1977",true),Answer("1972",false))))


public fun getQuestions():List<Question>{
    return questions.shuffled()
}