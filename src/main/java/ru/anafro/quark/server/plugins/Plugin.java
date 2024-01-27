package ru.anafro.quark.server.plugins;

import ru.anafro.quark.server.logging.Logger;

/**
 * Quark Plugin API makes Quark extremely powerful. It opens
 * a gate to the world of unlimited extending of functionality.
 * <p>
 * To know how to use Quark Plugin API, read the information at
 * official Quark GitHub: <a href="https://github.com/anafro/quark">here</a>.
 * <p>
 * If you are too lazy to read the whole article (or just don't have so much time),
 * read the steps below to understand how to create your first simple plugin:
 *
 * <ol>
 *     <li>
 *         First, create a project in your IDE or code editor. Name it somehow.
 *     </li>
 *     <li>
 *         Then, create a new class like this: Your project name + "Plugin".
 *         Let's say you want to create a "Cake" plugin, so you need to create your
 *         class "CakePlugin".
 *     </li>
 *     <li>
 *         Created a class? Then, inherit from the {@link Plugin} class.
 *     </li>
 *     <li>
 *         Implement the default constructor inside your class like so:
 *         <pre>
 *         {@code
 *             public CakePlugin() {
 *                 super(
 *                      "Cake",             // <- Plugin name
 *                      "Anatoly Frolov"    // <- Your name (Or the plugin author, if you wish)
 *                 );
 *             }
 *         }
 *         </pre>
 * <p>
 *         Don't forget to remove the default constructor arguments probably generated by your IDE:
 *
 *         <pre>
 *         {@code
 *             //                ~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~~~~~~~~~
 *             public CakePlugin(String pluginName, String pluginAuthor) { // Plugin won't work if you leave these arguments.
 *                 super("Cake", "Anatoly Frolov");
 *             }
 *         }
 *         </pre>
 *     </li>
 *     <li>
 *         After that, implement an <code>onEnable()</code> method.
 *         <pre>
 *         {@code
 *              @Override
 *              public void onEnable() {
 *                  logger.info("Hello from the Cake!");
 *              }
 *         }
 *         </pre>
 *         This method will be run before the server startup. It should be
 *         used for plugin initialization, like file loading or connecting with API
 *         in the Internet, but we can leave it like so.
 *     </li>
 *     <li>
 *         To make our plugin more interesting, let's add a new console command!
 *         Adding a new command should be in the constructor or inside the <code>onEnable</code>
 *         method.
 *
 *         <pre>
 *         {@code
 *             public CakePlugin() {
 *                 super("Cake", "Anatoly Frolov");
 *
 *                 Quark.commands().add(new CommandBuilder()
 *                      .name("cake")
 *                      .shortDescription("Gives you a cake")
 *                      .longDescription("Makes a really tasty cake and gives it to you!")
 *                      .action(arguments -> logger.info("Hey! There's a cake for you! Is it tasty? :)"))
 *                 );
 *             }
 *         }
 *         </pre>
 *     </li>
 *     <li>
 *         Our plugin is almost done! Create a new file named "Plugin Class Path.txt" inside project's resources.
 *         Put a full package path to your class including the class' name. For example:
 *         <pre>
 *             io.cakemaker.CakePlugin
 *         </pre>
 *     </li>
 *     <li>
 *         Compile your project into a .jar-file and put into "Plugins" folder inside Quark Server and reload the server.
 *     </li>
 *     <li>
 *         That's it! Enjoy your cake plugin (or another plugin you made) :)
 *     </li>
 * </ol>
 *
 * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
 * @see Plugin#Plugin(String, String)
 * @since Quark 1.1
 */
public class Plugin {
    protected final String name;
    protected final String author;
    protected final Logger logger;

    /**
     * Creates a new plugin object. Call it inside your plugin constructor and
     * <strong>don't forget to remove the constructor's arguments (all of them)</strong>.
     *
     * @param pluginName   your plugin name.
     * @param pluginAuthor your name.
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     * @since Quark 1.1
     */
    public Plugin(String pluginName, String pluginAuthor) {
        this.name = pluginName;
        this.author = pluginAuthor;
        this.logger = new Logger(STR."Plugin '\{name}'");
    }

    /**
     * This method will be run before the server startup.
     * Override it to initialize your plugins (load files you need, run commands you need and so on).
     *
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     * @since Quark 1.1
     */
    public void onEnable() {
        logger.info(STR."Enabled plugin: \{name}");
    }

    /**
     * Returns a name of the plugin.
     *
     * @return the plugin's name.
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     * @since Quark 1.1
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a logger of the plugin.
     *
     * @return the plugin's logger.
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     * @since Quark 1.1
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Returns a name of the author that created this plugin.
     *
     * @return the author's name.
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     * @since Quark 1.1
     */
    public String getAuthor() {
        return author;
    }
}
