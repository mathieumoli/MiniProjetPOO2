package zuul.intl;

import java.util.ListResourceBundle;

/**
 * @author Lucas Martinez
 * @version 20/11/2014
 */
public class Zuul extends ListResourceBundle {
    static final Object[][] contents = {
            {"hall.description", "Vous êtes dans le hall"},
            {"lunchroom.description", "Vous êtes dans la cafétéria"},
            {"lectureroom.description", "Vous êtes dans la salle de classe"},
            {"labroom.description", "Vous êtes dans la salle de TP"},
            {"corridor1.description", "Vous êtes dans le premier couloir"},
            {"corridor2.description", "Vous êtes dans le deuxième couloir"},
            {"library.description", "Vous êtes dans la bibliothèque"},
            {"examroom.description", "Vous êtes dans la salle d'examen"},
            {"darkcorridor.explication","Ce couloir est d'une obscurité déconcertante, vous pourriez allumer la lumiere pour mieux y voir..."},

            {"game.welcome", "Bienvenue dans Le Monde de Zuul!"},
            {"game.boring", "Le Monde de Zuul est un nouveau jeu d'aventure incroyablement (un peu moins) chiant."},
            {"game.help", "Tapez 'help' si vous avez besoin d'aide."},
            {"game.idontknow", "Je ne comprends pas..."},
            {"game.help2", "Vous êtes un étudiant et vous devez passer l'examen final de POO."},
            {"game.help3", "Pour cela, vous devez suivre des cours, des TP et réussir l'examen."},
            {"game.help4", "Les commandes sont:"},
            {"game.where", "Aller où?"},
            {"game.nodoor", "Il n'y a pas de porte !"},
            {"game.quitwhat", "Quitter quoi?"},
            {"game.exits", "Sorties:"},
            {"game.thankyou", "Merci d'avoir joué. Au revoir."}

    };


    @Override
    public Object[][] getContents() {
        return contents;
    }
}
