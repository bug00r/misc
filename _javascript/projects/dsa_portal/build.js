const fs = require('fs');
const path = require('path');

const handler = {};

const version = "0.0-1";
const build_dir = "build";
const temp_dir = path.join(build_dir, "tmp");
const target_dir = path.join(build_dir, version);
const target_js_dir = path.join(target_dir, "js");
const target_css_dir = path.join(target_dir, "css");

const src_resource_dir = 'resources';
const src_text_dir = path.join(src_resource_dir, "text");
const src_html_dir = path.join(src_resource_dir, "html");
const src_xml_dir = path.join(src_resource_dir, "xml");
const src_js_dir = path.join(src_resource_dir, "js");
const src_css_dir = path.join(src_resource_dir, "css");

const target_resource_js = path.join(target_js_dir, "resource.js");

const src_text_json = path.join(src_text_dir, "de_DE.json");

//bad bad developer you copied this from StackOverflow here: https://stackoverflow.com/questions/18052762/remove-directory-which-is-not-empty
var deleteFolderRecursive = function(path) {
  if (fs.existsSync(path)) {
    fs.readdirSync(path).forEach(function(file, index){
      var curPath = path + "/" + file;
      if (fs.lstatSync(curPath).isDirectory()) { // recurse
        deleteFolderRecursive(curPath);
      } else { // delete file
        fs.unlinkSync(curPath);
      }
    });
    fs.rmdirSync(path);
  }
};

handler.clean = function() {
    if ( fs.existsSync(build_dir) ) {
        deleteFolderRecursive(build_dir);
    }
}

handler.mkbuild = function() {

    for (var cdir of [build_dir, target_dir, temp_dir, target_js_dir, target_css_dir] ) {
        if ( !fs.existsSync(cdir) ) {
            fs.mkdirSync(cdir, {recursive: true});
        }
    }

}

handler.copyindex = function() {
    fs.copyFileSync(
        path.join(src_html_dir, "index.html"),
        path.join(target_dir, "index.html")
    );
}

handler.copyjs = function() {
    for (var jsfile of fs.readdirSync(src_js_dir)) {
        fs.copyFileSync(
            path.join(src_js_dir, jsfile),
            path.join(target_js_dir, jsfile)
        );
    }
}

handler.copycss = function() {
    for (var cssfile of fs.readdirSync(src_css_dir)) {
        fs.copyFileSync(
            path.join(src_css_dir, cssfile),
            path.join(target_css_dir, cssfile)
        );
    }
}

handler.prep_txt = function() {
    var resource = fs.readFileSync(target_resource_js, {encoding : 'utf8'});
    var text = fs.readFileSync(src_text_json, {encoding : 'utf8'});
    var resource_replaced = resource.replace("\"text_resource\"", text);
    fs.writeFileSync(target_resource_js, resource_replaced);
}

handler.prep_xml = function() {
    var resource = fs.readFileSync(target_resource_js, {encoding : 'utf8'});
    for (var xmlfile of fs.readdirSync(src_xml_dir)) {
        var cur_xml = fs.readFileSync(path.join(src_xml_dir, xmlfile) , {encoding : 'utf8'});
        resource = resource.replace(xmlfile, Buffer.from(cur_xml).toString('base64'));
    }

    fs.writeFileSync(target_resource_js, resource);
}

handler.build = function() { 
    handler.copyindex();
    handler.copyjs();
    handler.copycss();
    handler.prep_txt();
    handler.prep_xml();
}

handler[process.argv[2]]();