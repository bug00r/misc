
var portal = new Vue({
    el: "#portal-app",
    data: {
        apps: [],
        appname: ""
    },
    mounted: function() {
        $.getJSON("/portal/apps",function(appdata) {
            for(app in appdata) {
                portal.$data.apps.push(appdata[app]);
            }
        });
    },
    methods: {
        startApp: function(event) {
            var app = $(event.target).data('application');
            $.ajax({
                method: "GET",
                url: "/portal/" + app
              })
                .done(function( msg ) {
                    $( "#center" ).html( msg );
            });
        }
    }
})
