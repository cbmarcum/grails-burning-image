package burning.image

import grails.plugins.*

class BurningImageGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.1.8 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "grails-app/domain/pl/burningice/plugins/image/ast/test/**",
            "resources/**",
            "web-app/**"
    ]

    // TODO Fill in these fields
    def title = "Burning Image" // Headline display name of the plugin
    def author = "Pawel Gdula"
    def authorEmail = "pawel.gdula@burningice.pl"
    def description = '''\
Image manipulation plugin that allows you to easily attach images to any domain class via an annotation. You can also configure the plugin to scale images and perform other operation.
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://code.google.com/p/burningimage/"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [name: "Pawel Gdula", email: "pawel.gdula@burningice.pl"], [ name: "Rohit Bishnoi", email: "rbdharnia@gmail.com" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "Github", url: "https://github.com/gpc/grails-burning-image" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/gpc/grails-burning-image" ]

    Closure doWithSpring() { {->
        resourcePathProvider(pl.burningice.plugins.image.ResourcePathProvider)

        containerWorkerFactory(pl.burningice.plugins.image.container.ContainerWorkerFactory){
            resourcePathProvider = ref('resourcePathProvider')
        }
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
