/* The following code was generated by JFlex 1.4.3 on 8/11/24, 3:51 a.m. */

package analisis;

import static analisis.Tokens.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 8/11/24, 3:51 a.m. from the specification file
 * <tt>/Users/araelhidalgojuarez/NetbeansProjects/EstructurasPseudocodigo/src/analisis/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\12\0\1\42\25\0\1\40\13\0\1\3\3\0\12\2\1\0\1\41"+
    "\5\0\1\26\1\1\1\4\1\1\1\30\7\1\1\17\2\1\1\24"+
    "\1\1\1\31\3\1\1\35\4\1\1\36\1\0\1\37\1\0\1\1"+
    "\1\0\1\7\1\1\1\23\1\21\1\6\1\22\1\27\1\1\1\12"+
    "\1\34\1\1\1\11\1\15\1\25\1\20\2\1\1\5\1\13\1\14"+
    "\1\33\1\32\2\1\1\10\1\16\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\3\2\1\4\13\2\1\5"+
    "\1\6\1\7\1\10\1\0\2\2\1\11\5\2\1\12"+
    "\10\2\1\13\21\2\1\14\15\2\1\15\1\16\1\17"+
    "\12\2\1\20\2\2\1\21\4\2\1\22\1\23\1\24"+
    "\1\2\1\25\1\26\1\2\1\27\1\2\1\30\1\31";

  private static int [] zzUnpackAction() {
    int [] result = new int[105];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\43\0\106\0\151\0\214\0\257\0\322\0\365"+
    "\0\u0118\0\u013b\0\u015e\0\u0181\0\u01a4\0\u01c7\0\u01ea\0\u020d"+
    "\0\u0230\0\u0253\0\u0276\0\43\0\43\0\43\0\43\0\u0299"+
    "\0\u02bc\0\u02df\0\106\0\u0302\0\u0325\0\u0348\0\u036b\0\u038e"+
    "\0\106\0\u03b1\0\u03d4\0\u03f7\0\u041a\0\u043d\0\u0460\0\u0483"+
    "\0\u04a6\0\43\0\u04c9\0\u04ec\0\u050f\0\u0532\0\u0555\0\u0578"+
    "\0\u059b\0\u05be\0\u05e1\0\u0604\0\u0627\0\u064a\0\u066d\0\u0690"+
    "\0\u06b3\0\u06d6\0\u06f9\0\106\0\u071c\0\u073f\0\u0762\0\u0785"+
    "\0\u07a8\0\u07cb\0\u07ee\0\u0811\0\u0834\0\u0857\0\u087a\0\u089d"+
    "\0\u08c0\0\106\0\106\0\106\0\u08e3\0\u0906\0\u0929\0\u094c"+
    "\0\u096f\0\u0992\0\u09b5\0\u09d8\0\u09fb\0\u0a1e\0\106\0\u0a41"+
    "\0\u0a64\0\106\0\u0a87\0\u0aaa\0\u0acd\0\u0af0\0\106\0\106"+
    "\0\106\0\u0b13\0\106\0\106\0\u0b36\0\106\0\u0b59\0\106"+
    "\0\106";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[105];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\3\1\11\3\3\1\12\1\3\1\13\1\3\1\14"+
    "\2\3\1\15\1\3\1\16\1\3\1\17\1\20\1\21"+
    "\1\22\1\3\1\23\1\24\1\25\1\26\1\27\45\0"+
    "\2\3\1\0\32\3\10\0\1\30\40\0\2\3\1\0"+
    "\1\3\1\31\30\3\6\0\2\3\1\0\14\3\1\32"+
    "\15\3\6\0\2\3\1\0\21\3\1\33\10\3\6\0"+
    "\2\3\1\0\1\3\1\34\10\3\1\35\17\3\6\0"+
    "\2\3\1\0\6\3\1\36\23\3\6\0\2\3\1\0"+
    "\3\3\1\37\26\3\6\0\2\3\1\0\14\3\1\40"+
    "\15\3\6\0\2\3\1\0\2\3\1\41\27\3\6\0"+
    "\2\3\1\0\6\3\1\42\23\3\6\0\2\3\1\0"+
    "\7\3\1\43\13\3\1\44\6\3\6\0\2\3\1\0"+
    "\5\3\1\45\24\3\6\0\2\3\1\0\2\3\1\46"+
    "\27\3\6\0\2\3\1\0\2\3\1\47\27\3\6\0"+
    "\2\3\1\0\5\3\1\50\24\3\6\0\2\3\1\0"+
    "\3\3\1\51\26\3\7\0\1\52\41\0\2\3\1\0"+
    "\2\3\1\53\27\3\6\0\2\3\1\0\30\3\1\54"+
    "\1\3\6\0\2\3\1\0\1\3\1\55\30\3\6\0"+
    "\2\3\1\0\27\3\1\56\2\3\6\0\2\3\1\0"+
    "\7\3\1\57\22\3\6\0\2\3\1\0\10\3\1\60"+
    "\21\3\6\0\2\3\1\0\7\3\1\61\5\3\1\62"+
    "\14\3\6\0\2\3\1\0\21\3\1\63\10\3\6\0"+
    "\2\3\1\0\6\3\1\64\23\3\6\0\2\3\1\0"+
    "\1\3\1\65\30\3\6\0\2\3\1\0\6\3\1\66"+
    "\23\3\6\0\2\3\1\0\11\3\1\67\20\3\6\0"+
    "\2\3\1\0\1\3\1\70\30\3\6\0\2\3\1\0"+
    "\10\3\1\71\21\3\6\0\2\3\1\0\17\3\1\72"+
    "\12\3\6\0\2\3\1\0\3\3\1\73\26\3\6\0"+
    "\2\3\1\0\14\3\1\74\15\3\6\0\2\3\1\0"+
    "\3\3\1\75\26\3\6\0\2\3\1\0\5\3\1\74"+
    "\24\3\6\0\2\3\1\0\10\3\1\76\21\3\6\0"+
    "\2\3\1\0\1\3\1\77\30\3\6\0\2\3\1\0"+
    "\10\3\1\100\21\3\6\0\2\3\1\0\6\3\1\101"+
    "\23\3\6\0\2\3\1\0\10\3\1\102\21\3\6\0"+
    "\2\3\1\0\23\3\1\103\6\3\6\0\2\3\1\0"+
    "\2\3\1\104\27\3\6\0\2\3\1\0\11\3\1\105"+
    "\20\3\6\0\2\3\1\0\14\3\1\106\15\3\6\0"+
    "\2\3\1\0\15\3\1\107\14\3\6\0\2\3\1\0"+
    "\6\3\1\110\23\3\6\0\2\3\1\0\6\3\1\111"+
    "\23\3\6\0\2\3\1\0\1\3\1\112\30\3\6\0"+
    "\2\3\1\0\4\3\1\113\25\3\6\0\2\3\1\0"+
    "\3\3\1\114\26\3\6\0\2\3\1\0\6\3\1\115"+
    "\23\3\6\0\2\3\1\0\1\3\1\116\30\3\6\0"+
    "\2\3\1\0\16\3\1\117\13\3\6\0\2\3\1\0"+
    "\3\3\1\120\26\3\6\0\2\3\1\0\21\3\1\121"+
    "\10\3\6\0\2\3\1\0\23\3\1\122\6\3\6\0"+
    "\2\3\1\0\6\3\1\123\23\3\6\0\2\3\1\0"+
    "\26\3\1\124\3\3\6\0\2\3\1\0\2\3\1\74"+
    "\27\3\6\0\2\3\1\0\11\3\1\125\20\3\6\0"+
    "\2\3\1\0\3\3\1\126\26\3\6\0\2\3\1\0"+
    "\12\3\1\127\17\3\6\0\2\3\1\0\3\3\1\130"+
    "\26\3\6\0\2\3\1\0\6\3\1\131\23\3\6\0"+
    "\2\3\1\0\1\3\1\132\30\3\6\0\2\3\1\0"+
    "\3\3\1\133\26\3\6\0\2\3\1\0\3\3\1\134"+
    "\26\3\6\0\2\3\1\0\21\3\1\135\10\3\6\0"+
    "\2\3\1\0\2\3\1\136\27\3\6\0\2\3\1\0"+
    "\14\3\1\137\15\3\6\0\2\3\1\0\1\3\1\140"+
    "\30\3\6\0\2\3\1\0\1\3\1\141\30\3\6\0"+
    "\2\3\1\0\17\3\1\142\12\3\6\0\2\3\1\0"+
    "\1\3\1\143\30\3\6\0\2\3\1\0\1\3\1\144"+
    "\30\3\6\0\2\3\1\0\3\3\1\145\26\3\6\0"+
    "\2\3\1\0\1\3\1\146\30\3\6\0\2\3\1\0"+
    "\3\3\1\147\26\3\6\0\2\3\1\0\1\3\1\150"+
    "\30\3\6\0\2\3\1\0\1\3\1\151\30\3\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2940];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\21\1\4\11\1\0\21\1\1\11\77\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[105];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 112) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 13: 
          { lexeme = yytext();
    return CREAR;
          }
        case 26: break;
        case 7: 
          { lexeme = yytext();
    return ESPACIO;
          }
        case 27: break;
        case 14: 
          { lexeme = yytext();
    return ARRAY;
          }
        case 28: break;
        case 8: 
          { lexeme = yytext();
    return FINAL;
          }
        case 29: break;
        case 23: 
          { lexeme = yytext();
    return REMOVER;
          }
        case 30: break;
        case 15: 
          { lexeme = yytext();
    return LISTA;
          }
        case 31: break;
        case 6: 
          { lexeme = yytext();
    return CORCHETEC;
          }
        case 32: break;
        case 18: 
          { lexeme = yytext();
    return ULTIMO;
          }
        case 33: break;
        case 16: 
          { lexeme = yytext();
    return MATRIZ;
          }
        case 34: break;
        case 21: 
          { lexeme = yytext();
    return ASIGNAR;
          }
        case 35: break;
        case 3: 
          { lexeme = yytext();
    return DIGITO;
          }
        case 36: break;
        case 4: 
          { lexeme = yytext();
    return A;
          }
        case 37: break;
        case 9: 
          { lexeme = yytext();
    return EN;
          }
        case 38: break;
        case 22: 
          { lexeme = yytext();
    return AGREGAR;
          }
        case 39: break;
        case 20: 
          { lexeme = yytext();
    return MOSTRAR;
          }
        case 40: break;
        case 25: 
          { lexeme = yytext();
    return MODIFICAR;
          }
        case 41: break;
        case 11: 
          { lexeme = yytext();
    return INDICE_MATRIZ;
          }
        case 42: break;
        case 5: 
          { lexeme = yytext();
    return CORCHETEA;
          }
        case 43: break;
        case 17: 
          { lexeme = yytext();
    return PINTAR;
          }
        case 44: break;
        case 2: 
          { lexeme = yytext();
    return IDENTIFICADOR;
          }
        case 45: break;
        case 1: 
          { return ERROR;
          }
        case 46: break;
        case 24: 
          { lexeme = yytext();
    return ELIMINAR;
          }
        case 47: break;
        case 19: 
          { lexeme = yytext();
    return VACIAR;
          }
        case 48: break;
        case 12: 
          { lexeme = yytext();
    return COLOR;
          }
        case 49: break;
        case 10: 
          { lexeme = yytext();
    return DE;
          }
        case 50: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
