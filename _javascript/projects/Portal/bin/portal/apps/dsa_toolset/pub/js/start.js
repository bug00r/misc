
dsa_toolset = new Vue({
    el: "#dsa-toolset-app",
    data: {
        name: "DSA Toolset",
        features: []
    },
    mounted: function() {
        $.getJSON("/portal/dsa_toolset/features",function(featuredata) {
            for(feature in featuredata) {
                dsa_toolset.$data.features.push(featuredata[feature]);
            }
        });
        portal.$data.appname = this.name;
    },
    methods: {
        getThumb: function(icon) {
            return "portal/dsa_toolset/img/" + icon;
        },
        activateFeature: function(event, feature) {
            var that = this;
            portal.$data.appname = feature.name;
            if (!!!feature.loaded) {
                console.log("/portal/dsa_toolset/html/"+ feature.ui);
                $.ajax({
                    method: "GET",
                    url: "/portal/dsa_toolset/html/"+ feature.ui
                  })
                    .done(function( featurebody ) {
                        $(that.$refs[feature.uiid]).html(featurebody);
                });
                feature.loaded = true;
            }
        }
    }
})
