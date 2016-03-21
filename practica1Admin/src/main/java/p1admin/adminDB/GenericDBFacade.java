package p1admin.adminDB;

import java.util.List;

/**
 * Fachada de acceso a la base de datos.
 * 
 * Las implementaciones de esta interfaz hacen de puente entre la aplicación
 * gestora de preguntas y la base de datos que hayáis creado.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 * @param <Q> Clase del modelo que representa una pregunta.
 * @param <A> Clase del modelo que representa una opción de una pregunta
 * 
 */
public interface GenericDBFacade<Q, A> {
    /**
     * Inserta una pregunta en la base de datos.
     * 
     * Esta función no tiene que guardar las posibles respuestas de la pregunta
     * en la base de datos.
     * 
     * Esta función es llamada cuando el usuario hace clic en el botón {@code Añadir Pregunta},
     * justo tras introducir el enunciado de la misma.
     * 
     * @param question Pregunta a almacenar en la BD.
     */
    public void insertQuestion(Q question);
    
	/**
	 * Devuelve todas las preguntas de la base de datos.
	 * 
	 * Esta función es llamada al principio del programa, para llenar el JList
	 * de la ventana principal. También se llama cuando el usuario ha hecho clic
	 * en el botón {@code Filtrar} tras introducir la cadena vacía en el cuadro
	 * de texto correspondiente.
	 * 
	 * <b>Importante:</b> Esta función también ha de recuperar de la BD
	 * las opciones asociadas a cada pregunta.
	 * 
	 * @return Una lista con todas las preguntas de la base de datos
	 */
    public List<Q> getAllQuestions();
    
    /**
     * Devuelve todas las preguntas de la base de datos cuyo enunciado
     * contenga la cadena pasada como parámetro.
     * 
     * Esta función es llamada cuando el usuario pulsa el botón {@code Filtrar} tras
     * haber introducido una cadena de texto en el cuadro correspondiente.
     * <b>Importante:</b> Para cada pregunta, esta función ha de recuperar de la 
     * BD todas sus respuestas asociadas.
     * 
     * @param text Texto que ha de aparecer en las respuestas devueltas.
     * @return Lista con las preguntas cuyo enunciado contengan la cadena {@code text}.
     */
    public List<Q> findQuestionsContaining(String text);
    
    /**
     * Actualiza en la BD la información de la pregunta pasada como parámetro.
     * 
     * Esta función no tiene que actualizar la información de las posibles
     * respuestas asociadas a dicha pregunta. Tan sólo hay que modificar la
     * tabla que contiene la información de la pregunta en sí.
     * 
     * Se supone que la pregunta ya existe en la base de datos.
     * 
     * Esta función es llamada cuando el usuario cambia el botón del enunciado
     * de una pregunta.
     * 
     * @param question Pregunta a actualizar.
     */
    public void updateQuestion(Q question);
    
    /**
     * Actualiza en la BD la información de la respuesta (esto es, una de las
     * posibles opciones asociadas a una pregunta) pasada como parámetro.
     * 
     * Esta función es llamada cuando el usuario pulsa el botón {@code Editar}
     * del cuadro de diálogo de edición de pregunta.
     * 
     * En función del diseño de la base de datos que hayáis hecho, es posible
     * que el parámetro {@code question} no sea necesario.
     * 
     * @param question Pregunta que contiene la respuesta a actualizar.
     * @param answer Respuesta a actualizar.
     */
    public void updateAnswer(Q question, A answer);
    
    /**
     * Elimina de la BD la respuesta (u opción) pasada como parámetro.
     * 
     * Esta función es llamada cuando el usuario pulsa el botón {@code Eliminar}
     * del cuadro de diálogo de edición de pregunta.
     * 
     * @param question Pregunta que contiene la respuesta a eliminar (puede no ser necesario su uso).
     * @param answer Respuesta a eliminar.
     */
    public void deleteAnswer(Q question, A answer);
    
    /**
     * Elimina de la BD la pregunta pasada como parámetro.
     * 
     * Esta función es llamada cuando el usuario hace clic en el botón
     * {@code Eliminar pregunta} tras seleccionar una pregunta en la lista
     * principal.
     * 
     * Esta función <b>sí</b> ha de eliminar la lista de respuestas
     * 
     * @param question Pregunta a eliminar.
     */
    public void deleteQuestion(Q question);
    
    /**
     * Inserta una respuesta en la BD. 
     * 
     * Esta función es llamada cuando el usuario añade una nueva opción
     * en la pregunta actual.
     * 
     * @param question Pregunta a la que pertenece la acción.
     * @param answer Respuesta a insertar.
     */
    public void insertAnswer(Q question, A answer);
}
