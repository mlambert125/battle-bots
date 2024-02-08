package org.example;
import java.util.*;

/**
 * This class provides a set of static methods for colorizing text using ANSI escape codes.
 */
public class Ansi {
    /**
     * ANSI escape code for resetting all attributes.
     */
    public static final String	SANE				= "\u001B[0m";

    /**
     * ANSI escape codes for high intensity
     */
    public static final String	HIGH_INTENSITY		= "\u001B[1m";

    /**
     * ANSI escape codes for low intensity
     */
    public static final String	LOW_INTENSITY		= "\u001B[2m";

    /**
     * ANSI escape codes for italic
     */
    public static final String	ITALIC				= "\u001B[3m";

    /**
     * ANSI escape codes for underline
     */
    public static final String	UNDERLINE			= "\u001B[4m";

    /**
     * ANSI escape codes for blink
     */
    public static final String	BLINK				= "\u001B[5m";

    /**
     * ANSI escape codes for rapid blink
     */
    public static final String	RAPID_BLINK			= "\u001B[6m";

    /**
     * ANSI escape codes for reverse video
     */
    public static final String	REVERSE_VIDEO		= "\u001B[7m";

    /**
     * ANSI escape codes for invisible text
     */
    public static final String	INVISIBLE_TEXT		= "\u001B[8m";

    /**
     * ANSI escape codes for black foreground
     */
    public static final String	BLACK				= "\u001B[30m";

    /**
     * ANSI escape codes for red foreground
     */
    public static final String	RED					= "\u001B[31m";

    /**
     * ANSI escape codes for green foreground
     */
    public static final String	GREEN				= "\u001B[32m";

    /**
     * ANSI escape codes for yellow foreground
     */
    public static final String	YELLOW				= "\u001B[33m";

    /**
     * ANSI escape codes for blue foreground
     */
    public static final String	BLUE				= "\u001B[34m";

    /**
     * ANSI escape codes for magenta foreground
     */
    public static final String	MAGENTA				= "\u001B[35m";

    /**
     * ANSI escape codes for cyan foreground
     */
    public static final String	CYAN				= "\u001B[36m";

    /**
     * ANSI escape codes for white foreground
     */
    public static final String	WHITE				= "\u001B[37m";

    /**
     * ANSI escape codes for black background
     */
    public static final String	BACKGROUND_BLACK	= "\u001B[40m";

    /**
     * ANSI escape codes for red background
     */
    public static final String	BACKGROUND_RED		= "\u001B[41m";

    /**
     * ANSI escape codes for green background
     */
    public static final String	BACKGROUND_GREEN	= "\u001B[42m";

    /**
     * ANSI escape codes for yellow background
     */
    public static final String	BACKGROUND_YELLOW	= "\u001B[43m";

    /**
     * ANSI escape codes for blue background
     */
    public static final String	BACKGROUND_BLUE		= "\u001B[44m";

    /**
     * ANSI escape codes for magenta background
     */
    public static final String	BACKGROUND_MAGENTA	= "\u001B[45m";

    /**
     * ANSI escape codes for cyan background
     */
    public static final String	BACKGROUND_CYAN		= "\u001B[46m";

    /**
     * ANSI escape codes for white background
     */
    public static final String	BACKGROUND_WHITE	= "\u001B[47m";

    /**
     * Colorizes the given text using a list of ANSI codes from the constants above.
     *
     * @param text the text to colorize
     * @param codes the codes to use
     * @return the colorized text
     */
    public static String colorize(String text, List<String> codes) {
        StringBuilder sb = new StringBuilder();
        for (String code : codes) {
            sb.append(code);
        }
        sb.append(text);
        sb.append(SANE);
        return sb.toString();
    }

    /**
     * Colorizes the given text using a single ANSI code from the constants above.
     *
     * @param text the text to colorize
     * @param code the code to use
     * @return the colorized text
     */
    public static String colorize(String text, String code) {
        return colorize(text, Arrays.asList(code));
    }
}
