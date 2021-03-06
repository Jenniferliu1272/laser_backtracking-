package ptui;
import model.LasersModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class represents the controller portion of the plain text UI.
 * It takes the model from the view (LasersPTUI) so that it can perform
 * the operations that are input in the run method.
 *
 * @author Sean Strout @ RIT CS
 * @author Jordan Edward Shea
 * @author Jennifer Liu
 * @author Moses Lagoon
 */
public class ControllerPTUI  {
    /** The UI's connection to the model */
    private LasersModel model;

    /**
     * Construct the PTUI.  Create the model and initialize the view.
     * @param model The laser model
     */
    public ControllerPTUI(LasersModel model) {
        this.model = model;
    }

    /**
     * Run the main loop.  This is the entry point for the controller
     * @param inputFile The name of the input command file, if specified
     */
    // Jordan Shea
    public void run(String inputFile) throws FileNotFoundException {
        if (inputFile != null){
            Scanner sc = new Scanner(new File(inputFile));
            while (sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
                model.commands(line);
            }
        }
        Scanner scnInput = new Scanner(System.in);
        model.commands(scnInput.nextLine());
        while (scnInput.hasNextLine()) {
            model.commands(scnInput.nextLine());
        }
    }
}
