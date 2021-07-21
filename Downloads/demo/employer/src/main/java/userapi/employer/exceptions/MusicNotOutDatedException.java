package userapi.employer.exceptions;

public class MusicNotOutDatedException extends  RuntimeException {



    private String message;


    public MusicNotOutDatedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
