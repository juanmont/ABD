package p1admin.admincontroller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import p1admin.adminDB.GenericDBFacade;
import p1admin.adminview.QuestionEditor;
import p1admin.model.Opcion;
import p1admin.model.Pregunta;

/**
 * Controlador de la ventana principal.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AllQuestionsController {
    private final GenericDBFacade<Pregunta, Opcion> dao;
    private final DefaultListModel<Pregunta> questionsModel;
    
    

    public AllQuestionsController(DefaultListModel<Pregunta> questionsModel, GenericDBFacade<Pregunta, Opcion> dao) {
        this.questionsModel = questionsModel;
        this.dao = dao;
    }
    
    
    
    public Pregunta newQuestion(JDialog parent)  {
    	Pregunta newQuestion = new Pregunta();
        String statement = JOptionPane.showInputDialog("Introduce el enunciado de la pregunta:");
        if (statement != null && !statement.trim().isEmpty()) {
        	newQuestion.setEnunciado(statement);
            DefaultListModel<Opcion> answersModel = new DefaultListModel<>();
            QuestionController ctrl = new QuestionController(dao, newQuestion, answersModel);
            QuestionEditor editor = new QuestionEditor(ctrl, answersModel);
            editor.setLocationRelativeTo(parent);
            dao.insertQuestion(newQuestion);
            editor.setVisible(true);
            questionsModel.addElement(newQuestion);
        }
        return newQuestion;
    }
    
    public void gatherAllQuestions() {
        List<Pregunta> questions = dao.getAllQuestions();
        questionsModel.clear();
        for (Pregunta q : questions) {
            questionsModel.addElement(q);
        }
    }
    
    public void findByName(String name) {
        List<Pregunta> questions = dao.findQuestionsContaining(name);
        questionsModel.clear();
        for (Pregunta q : questions) {
            questionsModel.addElement(q);
        }
    }

    public void removeQuestion(Pregunta selected) {
        questionsModel.removeElement(selected);
        dao.deleteQuestion(selected);
    }

    public void updateQuestion(Pregunta question, JDialog parent) {
        Iterable<Opcion> answers = question.getOpciones(); 
        DefaultListModel<Opcion> mod = new DefaultListModel<>();
        for (Opcion a : answers) {
            mod.addElement(a);
        }
        QuestionController ctrl = new QuestionController(dao, question, mod);
        QuestionEditor editor = new QuestionEditor(ctrl, mod);
        editor.setLocationRelativeTo(parent);
        editor.setVisible(true);
    }
    
}
