call mvn install -pl de.bug0r.bot:plugin-app-irc -Dmaven.test.skip=true
call mvn install -pl de.bug0r.bot:plugin-orakel -Dmaven.test.skip=true
call mvn install -pl de.bug0r.bot:plugin-zitate -Dmaven.test.skip=true
call mvn install -pl de.bug0r.bot:plugin-xwin -Dmaven.test.skip=true
call mvn assembly:single -pl de.bug0r.bot:Multibot -Dmaven.test.skip=true
call mvn assembly:single -pl de.bug0r.bot:Multibot-Terminal -Dmaven.test.skip=true