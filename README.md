# YARN MapRed 2 - Java

#### jar : filezilla for ubuntu

###### maven gestion cycle de vie
##### creation dev test deploiement

##### jar en local (package : yarn jar monjar.jar)

```bash
julie@julie-HP-Pavilion-TS-14-Notebook-PC:~/Bureau/Big Data Frameworks$ git clone https://github.com/makayel/hadoop-examples-mapreduce.git
Clonage dans 'hadoop-examples-mapreduce'...
remote: Enumerating objects: 58, done.
remote: Counting objects: 100% (3/3), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 58 (delta 0), reused 1 (delta 0), pack-reused 55
Dépaquetage des objets: 100% (58/58), fait.
```

### Install filezilla

```bash
julie@julie-HP-Pavilion-TS-14-Notebook-PC:~/Bureau/Big Data Frameworks$ sudo apt-get install filezilla
```

```bash
Lecture des listes de paquets... Fait
Construction de l'arbre des dépendances       
Lecture des informations d'état... Fait
Les paquets suivants ont été installés automatiquement et ne sont plus nécessaires :
  gir1.2-geocodeglib-1.0 libfwup1 libllvm6.0 libllvm6.0:i386
  linux-headers-4.15.0-46 linux-headers-4.15.0-46-generic
  linux-image-4.15.0-46-generic linux-modules-4.15.0-46-generic
  linux-modules-extra-4.15.0-46-generic ubuntu-web-launchers
Veuillez utiliser « sudo apt autoremove » pour les supprimer.
Les paquets supplémentaires suivants seront installés : 
  filezilla-common libfilezilla0 libpugixml1v5 libwxgtk3.0-0v5
Les NOUVEAUX paquets suivants seront installés :
  filezilla filezilla-common libfilezilla0 libpugixml1v5 libwxgtk3.0-0v5
0 mis à jour, 5 nouvellement installés, 0 à enlever et 40 non mis à jour.
Il est nécessaire de prendre 4 182 ko/8 405 ko dans les archives.
Après cette opération, 35,0 Mo d'espace disque supplémentaires seront utilisés.
Souhaitez-vous continuer ? [O/n] o
Réception de :1 http://fr.archive.ubuntu.com/ubuntu bionic/universe amd64 libwxgtk3.0-0v5 amd64 3.0.4+dfsg-3 [4 182 kB]
Réception de :1 http://fr.archive.ubuntu.com/ubuntu bionic/universe amd64 libwxgtk3.0-0v5 amd64 3.0.4+dfsg-3 [4 182 kB]
2 837 ko réceptionnés en 3min 27s (13,7 ko/s)                                  
Sélection du paquet filezilla-common précédemment désélectionné.
(Lecture de la base de données... 315373 fichiers et répertoires déjà installés.)
Préparation du dépaquetage de .../filezilla-common_3.28.0-1_all.deb ...
Dépaquetage de filezilla-common (3.28.0-1) ...
Sélection du paquet libfilezilla0 précédemment désélectionné.
Préparation du dépaquetage de .../libfilezilla0_0.11.0-1_amd64.deb ...
Dépaquetage de libfilezilla0 (0.11.0-1) ...
Sélection du paquet libpugixml1v5:amd64 précédemment désélectionné.
Préparation du dépaquetage de .../libpugixml1v5_1.8.1-7_amd64.deb ...
Dépaquetage de libpugixml1v5:amd64 (1.8.1-7) ...
Sélection du paquet libwxgtk3.0-0v5:amd64 précédemment désélectionné.
Préparation du dépaquetage de .../libwxgtk3.0-0v5_3.0.4+dfsg-3_amd64.deb ...
Dépaquetage de libwxgtk3.0-0v5:amd64 (3.0.4+dfsg-3) ...
Sélection du paquet filezilla précédemment désélectionné.
Préparation du dépaquetage de .../filezilla_3.28.0-1_amd64.deb ...
Dépaquetage de filezilla (3.28.0-1) ...
Paramétrage de libpugixml1v5:amd64 (1.8.1-7) ...
Paramétrage de libwxgtk3.0-0v5:amd64 (3.0.4+dfsg-3) ...
Paramétrage de filezilla-common (3.28.0-1) ...
Paramétrage de libfilezilla0 (0.11.0-1) ...
Paramétrage de filezilla (3.28.0-1) ...
Traitement des actions différées (« triggers ») pour desktop-file-utils (0.23-1ubuntu3.18.04.2) ...
Traitement des actions différées (« triggers ») pour bamfdaemon (0.5.3+18.04.20180207.2-0ubuntu1) ...
Rebuilding /usr/share/applications/bamf-2.index...
Traitement des actions différées (« triggers ») pour libc-bin (2.27-3ubuntu1.4) ...
Traitement des actions différées (« triggers ») pour man-db (2.8.3-2ubuntu0.1) ...
Traitement des actions différées (« triggers ») pour gnome-menus (3.13.3-11ubuntu1.1) ...
Traitement des actions différées (« triggers ») pour hicolor-icon-theme (0.17-2) ...
Traitement des actions différées (« triggers ») pour mime-support (3.60ubuntu1) ...
```

### Run YARN MR : wordcount

```bash
[julie.ngan@hadoop-edge01 ~]$ yarn jar /usr/odp/current/hadoop-mapreduce-client/hadoop-mapreduce-examples.jar \wordcount
Usage: wordcount <in> [<in>...] <out>
```

### Parse CSV and display list of districts

#### Retrieve trees.csv from local
```bash
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -put trees.csv
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -ls
Found 10 items
drwx------   - julie.ngan julie.ngan          0 2021-09-30 20:00 .Trash
drwx------   - julie.ngan julie.ngan          0 2021-10-28 09:42 .staging
-rw-rw-rw-   1 julie.ngan julie.ngan         18 2021-10-05 19:51 bonjour.txt
drwxr-xr-x   - julie.ngan julie.ngan          0 2021-10-21 22:07 books
drwxr-xr-x   - julie.ngan julie.ngan          0 2021-10-28 09:42 books-output2
drwxr-xr-x   - julie.ngan julie.ngan          0 2021-10-21 15:00 data
-rw-r--r--   1 julie.ngan julie.ngan     448821 2021-10-21 13:23 frankenstein.txt
drwxr-xr-x   - julie.ngan julie.ngan          0 2021-10-03 16:45 raw
-rw-r--r--   3 julie.ngan julie.ngan      16680 2021-11-04 10:24 trees.csv
drwxr-xr-x   - julie.ngan julie.ngan          0 2021-10-21 13:25 wordcount
[julie.ngan@hadoop-edge01 ~]$ 
```

#### Copy the project with filezilla

#### Retrieve the default launch job of the project 

```bash
[julie.ngan@hadoop-edge01 ~]$ alias launch_job="yarn jar ~/YARN_JAVA_MR/target/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar"
```

```bash
[julie.ngan@hadoop-edge01 target]$ launch_job wordcount trees.csv count
```


### Wordcount result
```bash
Exception in thread "main" java.io.IOException: Error opening job jar: /home/julie.ngan/YARN_JAVA_MR/target/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar
	at org.apache.hadoop.util.RunJar.run(RunJar.java:261)
	at org.apache.hadoop.util.RunJar.main(RunJar.java:236)
Caused by: java.util.zip.ZipException: error in opening zip file
	at java.util.zip.ZipFile.open(Native Method)
	at java.util.zip.ZipFile.<init>(ZipFile.java:228)
	at java.util.zip.ZipFile.<init>(ZipFile.java:157)
	at java.util.jar.JarFile.<init>(JarFile.java:169)
	at java.util.jar.JarFile.<init>(JarFile.java:106)
	at org.apache.hadoop.util.RunJar.run(RunJar.java:259)
	... 1 more
[julie.ngan@hadoop-edge01 target]$ alias launch_job="yarn jar ~/YARN_JAVA_MR/target/hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar"
[julie.ngan@hadoop-edge01 target]$ launch_job wordcount trees.csv count
21/11/04 11:05:25 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/04 11:05:25 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/04 11:05:25 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636020325738, maxDate=1636625125738, sequenceNumber=6659, masterKeyId=78 on ha-hdfs:efrei
21/11/04 11:05:25 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636020325738, maxDate=1636625125738, sequenceNumber=6659, masterKeyId=78)
21/11/04 11:05:25 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
21/11/04 11:05:25 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/julie.ngan/.staging/job_1630864376208_4551
21/11/04 11:05:27 INFO input.FileInputFormat: Total input files to process : 1
21/11/04 11:05:27 INFO mapreduce.JobSubmitter: number of splits:1
21/11/04 11:05:27 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1630864376208_4551
21/11/04 11:05:27 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636020325738, maxDate=1636625125738, sequenceNumber=6659, masterKeyId=78)]
21/11/04 11:05:27 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.0.3.0-223/0/resource-types.xml
21/11/04 11:05:27 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
21/11/04 11:05:28 INFO impl.YarnClientImpl: Submitted application application_1630864376208_4551
21/11/04 11:05:28 INFO mapreduce.Job: The url to track the job: https://hadoop-master02.efrei.online:8090/proxy/application_1630864376208_4551/
21/11/04 11:05:28 INFO mapreduce.Job: Running job: job_1630864376208_4551
21/11/04 11:05:38 INFO mapreduce.Job: Job job_1630864376208_4551 running in uber mode : false
21/11/04 11:05:38 INFO mapreduce.Job:  map 0% reduce 0%
21/11/04 11:05:46 INFO mapreduce.Job:  map 100% reduce 0%
21/11/04 11:05:52 INFO mapreduce.Job:  map 100% reduce 100%
21/11/04 11:05:52 INFO mapreduce.Job: Job job_1630864376208_4551 completed successfully
21/11/04 11:05:52 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=16561
		FILE: Number of bytes written=559129
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16783
		HDFS: Number of bytes written=14251
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20370
		Total time spent by all reduces in occupied slots (ms)=10536
		Total time spent by all map tasks (ms)=6790
		Total time spent by all reduce tasks (ms)=2634
		Total vcore-milliseconds taken by all map tasks=6790
		Total vcore-milliseconds taken by all reduce tasks=2634
		Total megabyte-milliseconds taken by all map tasks=10429440
		Total megabyte-milliseconds taken by all reduce tasks=5394432
	Map-Reduce Framework
		Map input records=98
		Map output records=1219
		Map output bytes=21556
		Map output materialized bytes=16561
		Input split bytes=103
		Combine input records=1219
		Combine output records=579
		Reduce input groups=579
		Reduce shuffle bytes=16561
		Reduce input records=579
		Reduce output records=579
		Spilled Records=1158
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=185
		CPU time spent (ms)=2700
		Physical memory (bytes) snapshot=1450426368
		Virtual memory (bytes) snapshot=7281455104
		Total committed heap usage (bytes)=1513095168
		Peak Map Physical memory (bytes)=1157615616
		Peak Map Virtual memory (bytes)=3401347072
		Peak Reduce Physical memory (bytes)=292810752
		Peak Reduce Virtual memory (bytes)=3880108032
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=14251
```


### Directory files' size and counts
```bash
[julie.ngan@hadoop-edge01 target]$ hdfs dfs -cat count/part-r-00000
(48.8183933679,	1
(48.8201249835,	1
(48.8204495642,	1
(48.8210086122,	1
(48.8213214388,	1
(48.8215800145,	1
(48.8220238534,	1
(48.8224956954,	1
(48.8226749117,	1
(48.8232165418,	1
(48.827737189,	1
(48.8292071873,	1
(48.8302532096,	1
(48.8314334738,	1
(48.8319232533,	1
(48.8320684332,	1
(48.8323806372,	1
(48.8324049718,	1
(48.8325900983,	1
(48.8330496955,	1
(48.8333849101,	1
(48.833545551,	1
(48.8336849895,	1
(48.8341842636,	1
(48.8347628794,	1
(48.8353848188,	1
(48.8373323894,	1
(48.8394165343,	1
(48.8395160905,	1
(48.8399672948,	1
(48.8400020891,	1
(48.8400754064,	1
(48.8420426954,	1
(48.8428118006,	1
(48.8433252639,	1
(48.8450859307,	1
(48.8453050031,	1
(48.846044762,	1
(48.8471653404,	1
(48.8471789821,	1
(48.8476260928,	1
(48.8520958913,	1
(48.8557581795,	1
(48.85646631,	1
(48.856902513,	1
(48.857140829,	1
(48.8577766649,	1
(48.8578717375,	1
(48.8588189763,	1
(48.8597396934,	1
(48.8606198209,	1
(48.861574817,	1
(48.8615768444,	1
(48.8618464812,	1
(48.8619170093,	1
(48.8619346483,	1
(48.8622517606,	1
(48.86260617,	1
(48.8630909172,	1
(48.8632834941,	1
(48.8633555664,	1
(48.8634848878,	1
(48.8640166469,	1
(48.8646024472,	1
(48.8646850734,	1
(48.8647824278,	1
(48.8648376291,	1
(48.865022534,	1
(48.8652536076,	1
(48.8661956075,	1
(48.8669690843,	1
(48.867043584,	1
(48.867221687,	1
(48.8685686134,	1
(48.8691433358,	1
(48.8691485018,	1
(48.8693939056,	1
(48.8704017043,	1
(48.8708601366,	1
(48.8716117578,	1
(48.8717782491,	1
(48.8723867386,	1
(48.8727584235,	1
(48.8731203887,	1
(48.8732545226,	1
(48.8764503804,	1
(48.8768191638,	1
(48.8785456147,	1
(48.8792159582,	1
(48.879759998,	1
(48.8802898189,	1
(48.8803986732,	1
(48.8814628758,	1
(48.8820015094,	1
(48.8830346813,	1
(48.8845880534,	1
(48.8880577555,	1
(Bagatelle)	7
(Berge	4
(Cours	1
(Ecole	2
(Grande	1
(Ile	7
(Lac	2
(Moulin	1
(Portes	1
(Pré	4
(Route	1
(Saint	1
(Square	1
(fort	1
(lac	4
(pelouse	1
(pente	1
(petite	1
(réservoir	2
(square	3
(île	1
1	4
11	2
148	1
2.23782412563);16;Zelkova;carpinifolia;Ulmaceae;1896;16.0;260.0;;Faux	1
2.2403752961);16;Cedrus;libanii;Pinaceae;1862;30.0;460.0;All‚e	1
2.24066981564);16;Taxodium;distichum;Taxodiaceae;1859;30.0;290.0;Allée	1
2.24159242682);16;Pinus;nigra	1
2.24587597613);16;Platanus;x	1
2.24769299518);16;Taxus;baccata;Taxaceae;1772;13.0;235.0;Allée	1
2.24776773334);16;Sequoiadendron;giganteum;Taxodiaceae;1850;30.0;490.0;Allée	1
2.24852577475);16;Platanus;orientalis;Platanaceae;1843;26.0;340.0;Allée	1
2.24884917245);16;Fagus;sylvatica;Fagaceae;1868;15.0;230.0;Allée	1
2.24886543775);16;Davidia;involucrata;Cornaceae;1906;12.0;120.0;Allée	1
2.24933653506);16;Araucaria;araucana;Araucariaceae;1907;9.0;140.0;Allée	1
2.25120424857);16;Diospyros;kaki;Ebenaceae;1897;14.0;145.0;Route	1
2.25171449183);16;Sequoiadendron;giganteum;Taxodiaceae;1872;;655.0;Route	1
2.25199572129);16;Pterocarya;stenoptera;Juglandaceae;1905;30.0;530.0;3	1
2.25278179131);16;Ginkgo;biloba;Ginkgoaceae;1895;25.0;395.0;3	1
2.25293802515);16;Quercus;suber;Fagaceae;1895;10.0;180.0;3	1
2.2529555706);16;Ailanthus;giraldii;Simaroubaceae;;35.0;460.0;3	1
2.25320074406);16;Platanus;x	1
2.25360607406);16;Fagus;sylvatica;Fagaceae;1782;30.0;558.0;Route	1
2.2538285063);16;Pinus;nigra;Pinaceae;;30.0;250.0;Route	1
2.25765244347);16;Sequoiadendron;giganteum;Taxodiaceae;1850;30.0;;;Séquoia1
2.25832952119);16;Magnolia;grandiflora;Magnoliaceae;1863;12.0;;Allée	1
2.25902702441);16;Fagus;sylvatica;Fagaceae;1857;10.0;200.0;;Hêtre	1
2.2599223737);16;Taxodium;distichum;Taxodiaceae;1862;35.0;350.0;Berge	1
2.26098883991);16;Ginkgo;biloba;Ginkgoaceae;1893;18.0;215.0;;Arbre	1
2.26174532022);16;Pterocarya;fraxinifolia;Juglandaceae;1882;27.0;400.0;;Pérocarya	1
2.26238964912);16;Platanus;orientalis;Platanaceae;1859;25.0;375.0;Ile	1
2.26774597209);16;Fagus;sylvatica;Fagaceae;;18.0;300.0;;Hêtre	1
2.26948936839);16;Broussonetia;papyrifera;Moraceae;;12.0;190.0;Rue	1
2.27027693483);16;Cedrus;atlantica;Pinaceae;;6.0;195.0;;Cèdre	1
2.27224125103);16;Gymnocladus;dioicus;Fabaceae;;10.0;162.0;;Chicot	1
2.27912885453);16;Zelkova;carpinifolia;Ulmaceae;1852;30.0;395.0;Avenue	1
2.27973325759);16;Aesculus;hippocastanum;Sapindaceae;;30.0;505.0;Avenue	1
2.2873548507);16;Platanus;x	1
2.2910717819);16;Corylus;colurna;Betulaceae;;20.0;260.0;Place	1
2.2924448277);16;Paulownia;tomentosa;Paulowniaceae;;20.0;420.0;Place	1
2.29329076205);7;Platanus;orientalis;Platanaceae;1814;20.0;700.0;Quai	1
2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai	1
2.29706549763);7;Eucommia;ulmoides;Eucomiaceae;;12.0;190.0;Quai	1
2.2972574926);15;Alnus;glutinosa;Betulaceae;1933;16.0;220.0;Rue	1
2.30640768208);8;Ginkgo;biloba;Ginkgoaceae;1879;22.0;283.0;Boulevard	1
2.30757576047);8;Platanus;orientalis;Platanaceae;1814;31.0;700.0;Boulevard1
2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine,	1
2.31333976248);8;Platanus;orientalis;Platanaceae;1900;20.0;480.0;Cours-la-Reine,	1
2.31595908796);17;Platanus;x	1
2.31951408752);8;Sequoiadendron;giganteum;Taxodiaceae;1850;20.0;320.0;Cours-la-Reine,	1
2.33210374339);9;Pterocarya;fraxinifolia;Juglandaceae;1862;22.0;330.0;Place	1
2.33628540112);14;Sequoia;sempervirens;Taxodiaceae;1935;30.0;335.0;Bd	1
2.3366608746);14;Fagus;sylvatica;Fagaceae;;30.0;370.0;Bd	1
2.33666989768);6;Catalpa;bignonioides;Bignoniaceae;;15.0;260.0;Rue	1
2.33869560229);14;Platanus;x	1
2.34391859224);18;Platanus;orientalis;Platanaceae;1857;27.0;470.0;Place	1
2.34740754195);5;Robinia;pseudoacacia;Fabaceae;1601;11.0;385.0;Quai	1
2.35078878768);13;Aesculus;hippocastanum;Sapindaceae;1894;18.0;355.0;Rue	1
2.35307565328);5;Fagus;sylvatica;Fagaceae;1905;2.0;72.0;Rue	1
2.35399582218);4;Ulmus;carpinifolia;Ulmaceae;1935;15.0;180.0;Place	1
2.3592096955);13;Cedrus;atlantica;Pinaceae;1939;25.0;350.0;128-160	1
2.36062929978);3;Corylus;colurna;Betulaceae;1882;20.0;210.0;Rue	1
2.37007425143);19;Tilia;tomentosa;Malvaceae;1945;20.0;205.0;Place	1
2.37910176561);11;Corylus;colurna;Betulaceae;1879;20.0;245.0;Rue	1
2.38064802989);19;Sequoiadendron;giganteum;Taxodiaceae;;35.0;470.0;Rue	1
2.38129958306);19;Platanus;orientalis;Platanaceae;1862;34.0;670.0;Rue	1
2.38157245444);12;Platanus;x	1
2.38157469859);19;Ginkgo;biloba;Ginkgoaceae;1913;33.0;230.0;Rue	1
2.38367383179);19;Styphnolobium;japonicum;Fabaceae;1873;10.0;335.0;Rue	1
2.39469777758);20;Platanus;x	1
2.39836942721);19;Fraxinus;excelsior;Oleaceae;;30.0;365.0;Boulevard	1
2.39870061217);20;Acer;monspessulanum;Sapindacaees;1833;12.0;225.0;Rue	1
2.39997847741);20;Aesculus;hippocastanum;Sapindaceae;;22.0;345.0;Rue	1
2.40776275516);12;Celtis;australis;Cannabaceae;1906;16.0;295.0;27,	1
2.41033694606);12;Platanus;orientalis;Platanaceae;1860;22.0;475.0;route	1
2.41052012477);12;Platanus;x	1
2.41116455985);12;Platanus;x	1
2.4115101993);12;Diospyros;virginiana;Ebenaceae;1935;12.0;;Ile	1
2.41169855654);12;Taxodium;distichum;Taxodiaceae;1930;20.0;270.0;Ile	1
2.41182825531);12;Taxus;baccata;Taxaceae;1870;5.0;140.0;Ile	1
2.41202933239);12;Liriodendron;tulipifera;Magnoliaceae;1930;22.0;205.0;Ile1
2.41261756721);12;Juglans;nigra;Juglandaceae;1845;28.0;570.0;route	1
2.41301158121);12;Platanus;x	1
2.41400587444);12;Acer;opalus;Sapindaceae;1870;15.0;160.0;Ile	1
2.42029690936);12;Zelkova;serrata;Ulmaceae;1872;18.0;240.0;;Zelkova	1
2.42111102704);12;Ginkgo;biloba;Ginkgoaceae;1865;25.0;255.0;;Arbre	1
2.43350820893);12;Platanus;x	1
2.43360205128);12;Liriodendron;tulipifera;Magnoliaceae;1862;35.0;305.0;avenue	1
2.43375148978);12;Fagus;sylvatica;Fagaceae;1865;20.0;530.0;avenue	1
2.43381509843);12;Diospyros;virginiana;Ebenaceae;1875;14.0;180.0;avenue	1
2.43791766754);12;Quercus;ilex;Fagaceae;1860;15.0;;route	1
2.43848438671);12;Fagus;sylvatica;Fagaceae;1895;23.0;370.0;Cours	1
2.44524393613);12;Cedrus;libanii;Pinaceae;1829;30.0;440.0;route	1
2.44579219199);12;Pinus;nigra;Pinaceae;1870;25.0;248.0;route	1
2.4497117757);12;Quercus;petraea;Fagaceae;1815;31.0;450.0;;Chêne	1
2.45494779675);12;Zelkova;carpinifolia;Ulmaceae;;12.0;245.0;Route	1
2.45537251962);12;Pinus;bungeana;Pinaceae;;10.0;50.0;Route	1
2.45551492936);12;Pinus;coulteri;Pinaceae;;14.0;225.0;Route	1
2.46016871078);12;Diospyros;kaki;Ebenaceae;;12.0;160.0;Route	1
2.46130493573);12;Quercus;petraea;Fagaceae;1784;30.0;430.0;route	1
2.46422657197);12;Acer;cappadocicum;Sapindaceae;1900;16.0;280.0;avenue	1
27	1
Albert	2
Arènes	1
Arênes,	1
Bagatelle)	1
Bagatelle;Platane	1
Batignolles	1
Belle	1
Benett;Ailanthe;;53;Jardin	1
Benett;Arbre	1
Benett;Chêne	1
Benett;Ptérocarya	1
Benjamin	2
Bercy	1
Bercy)	7
Bercy;Cyprés	1
Bercy;Erable	1
Bercy;If	1
Bercy;Plaqueminier	1
Bercy;Platane	2
Bercy;Tulipier	1
Botzaris;Arbre	1
Botzaris;Platane	1
Botzaris;Sophora	1
Botzaris;Séquoia	1
Boulogne	23
Bourdonnais,	3
Branly,	3
Bretagne,	1
Breuil	4
Butte	1
Buttes	4
Byzance;;15;Square	1
Byzance;;1;Square	1
Byzance;;34;Jardin	1
COMMUN;VARIETE;OBJECTID;NOM_EV	1
Canada;;61;Square	1
Cappadoce;;78;Bois	1
Cardinet;Platane	1
Carnot)	4
Cascade)	1
Cascade,	4
Catelan)	4
Catelan;Hêtre	1
Catelan;Kaki;;68;Bois	1
Catelan;Pin	1
Catelan;Séquoia	1
Caucase;;14;Square	1
Caucase;;65;Bois	1
Champs	6
Chapeau	1
Charles	1
Charles-Moureu,	1
Charonne	1
Charonne;Platane	1
Chaumont	4
Chine;;54;Jardin	1
Choisy	1
Choisy,	1
Château	4
Cité‚-Universitaire,	3
Cordelières;Marronnier	1
Corse;;76;Bois	1
Corvisart,	1
Courcelles,	2
Croix	4
Croulebarbe,	1
Daumesnil,	4
Daumesnil/porte	2
Daumesnil;Noyer	1
Daumesnil;Platane	2
Debussy	1
Docteur	1
Docteur-Magn;Cèdre	1
Dorée)	2
Du	1
Ecole	4
Elysées	3
Emile-Deslandres,	1
Esplanade	4
Etienne	1
Eugène-Spuller;Noisetier	1
Ferme,	4
Filion,	1
Foch	3
Foch;Faux	1
Foch;Marronnier	1
Foch;Platane	1
Fontenay)	1
Formig‚,	1
Franklin,	2
Franklin-D.-Roosevelt,	3
François-Truffaut;Platane	1
GEOPOINT;ARRONDISSEMENT;GENRE;ESPECE;FAMILLE;ANNEE	1
Gabriel	1
Gabriel;Cèdre	1
Gabriel;Platane	1
Gabriel;Séquoia	1
Gabrielle;Erable	1
Gall	1
Gardette	1
Gazan,	3
Georges-Eastman,	1
Gervais	1
Gervais;Orme	1
Gordon	4
Grande	4
Gravelle)	2
Gravelle,	1
Général-Blaise;Noisetier	1
Général-Guilhem,	1
Inférieur)	1
Inférieur;Cyprés	1
Jacquem;Aulne	1
Japon;;44;Parc	1
Japon;;83;Bois	1
Jean	1
Joseph-Kessel,	1
Jourdan,	3
La	3
Lac	6
Lachaise	2
Lacharrière,	1
Lagrange,	1
Lambert	1
Le	1
Leclerc	1
Liban;;22;Bois	1
Liban;;37;Bois	1
Longchamp)	1
Longchamp,	11
Louise	1
Lutèce	1
L‚on-Lhermitte,	1
Manin,	4
Marigny)	1
Marigny;Hêtre	1
Mars	3
Mar‚chal	1
Matignon,	3
Maurice	2
Maurice);Chêne	1
Mazarine;Catalpa	1
Michel	1
Minimes;Chêne	1
Mirabeau,	1
Monceau	2
Monge;Faux	1
Montebello,	1
Montpellier;;48;Cimetière	1
Montsouris	3
Motte-Piquet,	3
Muette	1
Mun;Noisetier	1
Mun;Paulownia;;35;Jardin	1
Nansouty;Hêtre	1
Nansouty;Platane	1
Nansouty;Séquoia	1
Napoléon;;95;Arboretum	1
Navarre,	1
Neuilly;Arbre	1
Neuilly;Désespoir	1
Neuilly;Hêtre	1
Neuilly;If	1
Neuilly;Platane	2
Neuilly;Séquoia	1
Novembre,	2
Osages;;6;Parc	1
PLANTATION;HAUTEUR;CIRCONFERENCE;ADRESSE;NOM	1
Paul-Albert,	1
Paul-Belmondo,	1
Perinne	1
Perrée,	1
Pierné	1
Point	2
Porte	4
Provence;;16;Avenue	1
Pyramide;Faux	1
Pyramide;Kaki;;58;Jardin	1
Pyramide;Pin	2
Père	2
Reille,	3
René	1
Rochebrune,	1
Rondeaux;Erable	1
Rondeaux;Marronnier	1
Ronsard,	1
Rouge	1
Rue	1
Ruysdael;Arbre	1
Ruysdael;Platane	1
Saint	3
Saint-Julien-le-Pauvre;Robinier	1
Saint-Pierre,	1
Sainte	1
Schumann	1
Seine,	1
Serres	4
Sibérie;;29;Avenue	1
Sibérie;;50;Arboretum	1
Sibérie;;75;Bois	1
Soult	1
Soult;Micocoulier	1
St	1
Stalingrad	1
Stalingrad;Tilleul	1
Suffren;Arbre	1
Suffren;Oranger	1
Suffren;Platane	1
Sèvres	7
Temple	1
Temple,	1
Th‚ophraste-Renaudot,	1
Tourelle,	2
Trocadéro	2
Trocad‚ro	2
Utrillo;Platane	1
Van-Dyck,	2
Versailles;Murier	1
Verzy;Tortuosa;3;Square	1
Vincennes	23
Vincennes;Hêtre	1
Vincennes;Plaqueminier	1
Vincennes;Platane	1
Vincennes;Tulipier	1
Virginie;;81;Bois	1
Virginie;;88;Bois	1
Virginie;;93;Bois	1
Virginie;;94;Bois	1
Viviani	1
Vue;Cèdre	1
Vue;Pin	1
V‚lasquez,	2
acerifolia;Platanaceae;1840;30.0;595.0;Place	1
acerifolia;Platanaceae;1840;40.0;580.0;Bd	1
acerifolia;Platanaceae;1847;40.0;480.0;Allée	1
acerifolia;Platanaceae;1852;30.0;525.0;Avenue	1
acerifolia;Platanaceae;1860;42.0;405.0;Ile	1
acerifolia;Platanaceae;1860;45.0;405.0;Ile	1
acerifolia;Platanaceae;1871;25.0;490.0;route	1
acerifolia;Platanaceae;1872;40.0;520.0;Route	1
acerifolia;Platanaceae;1880;20.0;395.0;148	1
acerifolia;Platanaceae;1918;32.0;570.0;avenue	1
acerifolia;Platanaceae;;35.0;510.0;Rue	1
argenté;;43;Place	1
aux	7
avenue	39
bataille	1
bleu	2
boulevard	4
carrefour	8
cascade)	2
cascades;Cyprés	1
cascades;Cèdre	1
cascades;Magnolia	1
cascades;Pin	1
ceinture	3
champêtre;;2;Place	1
chauve;;56;Bois	1
chauve;;77;Bois	1
chauve;;87;Bois	1
chiens	2
commun;;17;Parc	1
commun;;21;Bois	1
commun;;26;Parc	1
commun;;36;Bois	1
commun;;40;Bois	1
commun;;41;Square	1
commun;;51;Alignement	1
commun;;52;Square	1
commun;;55;Avenue	1
commun;;5;Square	1
commun;;74;Bois	1
commun;;82;Bois	1
commun;;89;Bois	1
commun;;90;Bois	1
commun;;92;Bois	1
cônes;;96;Arboretum	1
d'Algérie;Frêne	1
d'Auteuil	4
d'Auteuil,	4
d'Estienne-d'Orves;Pérocarya	1
d'Inde;;23;Square	1
d'Inde;;30;Avenue	1
d'Inde;;47;Cimetière	1
d'Italie;;91;Bois	1
d'Orient;;13;Jardin	1
d'Orient;;42;Square	1
d'Orient;;45;Parc	1
d'Orient;;49;Bois	1
d'Orient;;73;Bois	1
d'Orient;;86;Bois	1
d'Orient;;8;Parc	1
d'Orient;;9;Parc	1
d'Orves	1
d'aveugle)	2
daumesnil)	1
de	172
des	24
du	51
encens;;11;Jardin	1
et	2
faux-acacia;;4;Square	1
fleurs;;66;Bois	1
glutineux;;28;Square	1
grande	1
grandes	1
grands	1
gravelle)	1
guide	2
gutta-percha;;7;Parc	1
géant;;12;Jardin	1
géant;;57;Parc	1
géant;;59;Bois	1
géant;;67;Bois	1
géant;;72;Bois	1
inférieur)	5
inférieur;Platane	1
james)	1
l'	1
l'Ambroise,	1
l'Atlas	1
l'Atlas;Glauca;24;Parc	1
la	36
lac	7
laricio;Pinaceae;1882;30.0;240.0;All‚e	1
liège;;32;Jardin	1
minimes)	1
neuf)	1
noir;;69;Bois	1
noir;;85;Bois	1
noir;Austriaca;97;Bois	1
orme	3
papier;;33;Parc	1
pendula;62;Square	1
ple;Glauca	1
pleureur;Pendula;20;Bois	1
pleureur;Pendula;63;Bois	1
pleureur;Pendula;70;Bois	1
pochettes;;71;Bois	1
pourpre;Purpurea;18;Bois	1
pourpre;Purpurea;25;Parc	1
pourpre;Purpurea;38;Bois	1
pourpre;Purpurea;60;Stade	1
quarante	5
repos,	2
ronde	1
route	14
rouve;;80;Bois	1
rouvre;;19;Bois	1
rue	43
sempervirent;;27;Parc	1
singe;;39;Bois	1
vert;;98;Bois	1
à	13
écus;;10;Parc	1
écus;;31;Jardin	1
écus;;46;Parc	1
écus;;64;Bois	1
écus;;84;Bois	1
île	1
```

### Run the DistinctDistricts job
#### TreesMapper.java
```bash
package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import javax.naming.Context;
import java.io.IOException;

public class TreesMapper extends Mapper<Object, Text, IntWritable, IntWritable> {
    public int curr_line = 0;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (curr_line != 0) {
            context.write(new IntWritable(Integer.parseInt(value.toString().split(";")[1])), new IntWritable(1));
        }
        curr_line++;
    }
}
```

#### TreesReducer.java
```bash
package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TreesReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
    public void reduce(IntWritable key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }
        context.write(key, new IntWritable(sum));
    }
}
```

#### DistinctDistricts.java
```bash
package com.opstty.job;

import com.opstty.mapper.TreesMapper;
import com.opstty.reducer.TreesReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistinctDistricts {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: distinctDistricts <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "distinctDistricts");
        job.setJarByClass(DistinctDistricts.class);
        job.setMapperClass(TreesMapper.class);
        job.setCombinerClass(TreesReducer.class);
        job.setReducerClass(TreesReducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
```

#### AppDriver.java
```bash
import com.opstty.job.DistinctDistricts;
import com.opstty.job.WordCount;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            programDriver.addClass("distinctDistricts", DistinctDistricts.class,
                    "A map/reduce program that returns the distinct districts of trees in a CSV.");
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
```


#### Refresh the maven/jar
```bash
julie@julie-HP-Pavilion-TS-14-Notebook-PC:~/Bureau/Big Data Frameworks/YARN_JAVA_MR$ mvn clean package
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< com.opstty:hadoop-examples-mapreduce >----------------
[INFO] Building hadoop-examples-mapreduce 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ hadoop-examples-mapreduce ---
[INFO] Deleting /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ hadoop-examples-mapreduce ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.6.1:compile (default-compile) @ hadoop-examples-mapreduce ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 7 source files to /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ hadoop-examples-mapreduce ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.6.1:testCompile (default-testCompile) @ hadoop-examples-mapreduce ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/target/test-classes
[INFO] /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/src/test/java/com/opstty/mapper/TokenizerMapperTest.java: Some input files use unchecked or unsafe operations.
[INFO] /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/src/test/java/com/opstty/mapper/TokenizerMapperTest.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ hadoop-examples-mapreduce ---
[INFO] Surefire report directory: /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.opstty.reducer.IntSumReducerTest
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.mockito.cglib.core.ReflectUtils$2 (file:/home/julie/.m2/repository/org/mockito/mockito-all/1.10.19/mockito-all-1.10.19.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of org.mockito.cglib.core.ReflectUtils$2
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.501 sec
Running com.opstty.mapper.TokenizerMapperTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ hadoop-examples-mapreduce ---
[INFO] Building jar: /home/julie/Bureau/Big Data Frameworks/YARN_JAVA_MR/target/hadoop-examples-mapreduce-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-assembly-plugin:2.2-beta-5:single (default) @ hadoop-examples-mapreduce ---
[INFO] META-INF/ already added, skipping
[INFO] META-INF/MANIFEST.MF already added, skipping
```



```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job distinctDistricts trees.csv districts
```

```bash
21/11/06 19:43:06 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/06 19:43:06 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/06 19:43:06 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636224186565, maxDate=1636828986565, sequenceNumber=7472, masterKeyId=80 on ha-hdfs:efrei
21/11/06 19:43:06 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636224186565, maxDate=1636828986565, sequenceNumber=7472, masterKeyId=80)
21/11/06 19:43:06 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
21/11/06 19:43:06 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/julie.ngan/.staging/job_1630864376208_4988
21/11/06 19:43:08 INFO input.FileInputFormat: Total input files to process : 1
21/11/06 19:43:08 INFO mapreduce.JobSubmitter: number of splits:1
21/11/06 19:43:08 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1630864376208_4988
21/11/06 19:43:08 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636224186565, maxDate=1636828986565, sequenceNumber=7472, masterKeyId=80)]
21/11/06 19:43:08 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.0.3.0-223/0/resource-types.xml
21/11/06 19:43:08 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
21/11/06 19:43:08 INFO impl.YarnClientImpl: Submitted application application_1630864376208_4988
21/11/06 19:43:09 INFO mapreduce.Job: The url to track the job: https://hadoop-master02.efrei.online:8090/proxy/application_1630864376208_4988/
21/11/06 19:43:09 INFO mapreduce.Job: Running job: job_1630864376208_4988
21/11/06 19:43:19 INFO mapreduce.Job: Job job_1630864376208_4988 running in uber mode : false
21/11/06 19:43:19 INFO mapreduce.Job:  map 0% reduce 0%
21/11/06 19:43:27 INFO mapreduce.Job:  map 100% reduce 0%
21/11/06 19:43:32 INFO mapreduce.Job:  map 100% reduce 100%
21/11/06 19:43:32 INFO mapreduce.Job: Job job_1630864376208_4988 completed successfully
21/11/06 19:43:32 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=176
		FILE: Number of bytes written=526385
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16783
		HDFS: Number of bytes written=80
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=18921
		Total time spent by all reduces in occupied slots (ms)=9988
		Total time spent by all map tasks (ms)=6307
		Total time spent by all reduce tasks (ms)=2497
		Total vcore-milliseconds taken by all map tasks=6307
		Total vcore-milliseconds taken by all reduce tasks=2497
		Total megabyte-milliseconds taken by all map tasks=9687552
		Total megabyte-milliseconds taken by all reduce tasks=5113856
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=776
		Map output materialized bytes=176
		Input split bytes=103
		Combine input records=97
		Combine output records=17
		Reduce input groups=17
		Reduce shuffle bytes=176
		Reduce input records=17
		Reduce output records=17
		Spilled Records=34
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=192
		CPU time spent (ms)=2300
		Physical memory (bytes) snapshot=1447424000
		Virtual memory (bytes) snapshot=7286034432
		Total committed heap usage (bytes)=1510473728
		Peak Map Physical memory (bytes)=1157574656
		Peak Map Virtual memory (bytes)=3404156928
		Peak Reduce Physical memory (bytes)=289849344
		Peak Reduce Virtual memory (bytes)=3881877504
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=80

```

#### Check the result

```bash
[julie.ngan@hadoop-edge01 ~]$ alias result='function _result() { hdfs dfs -cat "$1"/part-r-00000; } ; _result'
[julie.ngan@hadoop-edge01 ~]$ result districts
```
```bash
3	1
4	1
5	2
6	1
7	3
8	5
9	1
11	1
12	29
13	2
14	3
15	1
16	36
17	1
18	1
19	6
20	3
```
### 1.8.2 Show all existing species
#### SpeciesMapper.java
```bash
public class SpeciesMapper extends Mapper<Object, Text, Text, NullWritable> {
    public int curr_line = 0;
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (curr_line != 0) {
            context.write(new Text(value.toString().split(";")[3]), NullWritable.get());
        }
        curr_line++;
    }
}
```

#### SpeciesReducer.java
```bash
public class SpeciesReducer extends Reducer<Text, NullWritable, Text, NullWritable> {
    public void reduce(Text key, Iterable<NullWritable> values, Context context)
            throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
```
#### Species.java job
```bash
public class Species {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: tree species <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "treeSpecies");
        job.setJarByClass(Species.class);
        job.setMapperClass(SpeciesMapper.class);
        job.setCombinerClass(SpeciesReducer.class);
        job.setReducerClass(SpeciesReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
```

#### Launch treeSpecies job
```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job treeSpecies trees.csv species2
```

```bash
21/11/09 19:48:28 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/09 19:48:29 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/09 19:48:29 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636483709216, maxDate=1637088509216, sequenceNumber=7686, masterKeyId=85 on ha-hdfs:efrei
21/11/09 19:48:29 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636483709216, maxDate=1637088509216, sequenceNumber=7686, masterKeyId=85)
org.apache.hadoop.mapred.FileAlreadyExistsException: Output directory hdfs://efrei/user/julie.ngan/species already exists
	at org.apache.hadoop.mapreduce.lib.output.FileOutputFormat.checkOutputSpecs(FileOutputFormat.java:164)
	at org.apache.hadoop.mapreduce.JobSubmitter.checkSpecs(JobSubmitter.java:277)
	at org.apache.hadoop.mapreduce.JobSubmitter.submitJobInternal(JobSubmitter.java:143)
	at org.apache.hadoop.mapreduce.Job$11.run(Job.java:1565)
	at org.apache.hadoop.mapreduce.Job$11.run(Job.java:1562)
	at java.security.AccessController.doPrivileged(Native Method)
	at javax.security.auth.Subject.doAs(Subject.java:422)
	at org.apache.hadoop.security.UserGroupInformation.doAs(UserGroupInformation.java:1762)
	at org.apache.hadoop.mapreduce.Job.submit(Job.java:1562)
	at org.apache.hadoop.mapreduce.Job.waitForCompletion(Job.java:1583)
	at com.opstty.job.Species.main(Species.java:34)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.util.ProgramDriver$ProgramDescription.invoke(ProgramDriver.java:71)
	at org.apache.hadoop.util.ProgramDriver.run(ProgramDriver.java:144)
	at com.opstty.AppDriver.main(AppDriver.java:37)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.util.RunJar.run(RunJar.java:323)
	at org.apache.hadoop.util.RunJar.main(RunJar.java:236)
[julie.ngan@hadoop-edge01 ~]$ launch_job treeSpecies trees.csv species2
21/11/09 19:48:37 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/09 19:48:38 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/09 19:48:38 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636483718230, maxDate=1637088518230, sequenceNumber=7687, masterKeyId=85 on ha-hdfs:efrei
21/11/09 19:48:38 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636483718230, maxDate=1637088518230, sequenceNumber=7687, masterKeyId=85)
21/11/09 19:48:38 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
21/11/09 19:48:38 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/julie.ngan/.staging/job_1630864376208_5109
21/11/09 19:48:39 INFO input.FileInputFormat: Total input files to process : 1
21/11/09 19:48:39 INFO mapreduce.JobSubmitter: number of splits:1
21/11/09 19:48:39 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1630864376208_5109
21/11/09 19:48:39 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636483718230, maxDate=1637088518230, sequenceNumber=7687, masterKeyId=85)]
21/11/09 19:48:39 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.0.3.0-223/0/resource-types.xml
21/11/09 19:48:39 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
21/11/09 19:48:40 INFO impl.YarnClientImpl: Submitted application application_1630864376208_5109
21/11/09 19:48:40 INFO mapreduce.Job: The url to track the job: https://hadoop-master02.efrei.online:8090/proxy/application_1630864376208_5109/
21/11/09 19:48:40 INFO mapreduce.Job: Running job: job_1630864376208_5109
21/11/09 19:48:49 INFO mapreduce.Job: Job job_1630864376208_5109 running in uber mode : false
21/11/09 19:48:49 INFO mapreduce.Job:  map 0% reduce 0%
21/11/09 19:48:58 INFO mapreduce.Job:  map 100% reduce 0%
21/11/09 19:49:03 INFO mapreduce.Job:  map 100% reduce 100%
21/11/09 19:49:03 INFO mapreduce.Job: Job job_1630864376208_5109 completed successfully
21/11/09 19:49:03 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=547
		FILE: Number of bytes written=527735
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16783
		HDFS: Number of bytes written=451
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20013
		Total time spent by all reduces in occupied slots (ms)=10816
		Total time spent by all map tasks (ms)=6671
		Total time spent by all reduce tasks (ms)=2704
		Total vcore-milliseconds taken by all map tasks=6671
		Total vcore-milliseconds taken by all reduce tasks=2704
		Total megabyte-milliseconds taken by all map tasks=10246656
		Total megabyte-milliseconds taken by all reduce tasks=5537792
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=995
		Map output materialized bytes=547
		Input split bytes=103
		Combine input records=97
		Combine output records=45
		Reduce input groups=45
		Reduce shuffle bytes=547
		Reduce input records=45
		Reduce output records=45
		Spilled Records=90
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=178
		CPU time spent (ms)=2640
		Physical memory (bytes) snapshot=1449582592
		Virtual memory (bytes) snapshot=7281795072
		Total committed heap usage (bytes)=1506803712
		Peak Map Physical memory (bytes)=1156997120
		Peak Map Virtual memory (bytes)=3403120640
		Peak Reduce Physical memory (bytes)=292585472
		Peak Reduce Virtual memory (bytes)=3878674432
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=451
```

```bash
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -cat species2/part-r-00000
araucana
atlantica
australis
baccata
bignonioides
biloba
bungeana
cappadocicum
carpinifolia
colurna
coulteri
decurrens
dioicus
distichum
excelsior
fraxinifolia
giganteum
giraldii
glutinosa
grandiflora
hippocastanum
ilex
involucrata
japonicum
kaki
libanii
monspessulanum
nigra
nigra laricio
opalus
orientalis
papyrifera
petraea
pomifera
pseudoacacia
sempervirens
serrata
stenoptera
suber
sylvatica
tomentosa
tulipifera
ulmoides
virginiana
x acerifolia
```

### 1.8.3 Number of trees by kinds

```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job treeKindCount trees.csv kindcount5
```

```bash
21/11/09 20:55:28 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/09 20:55:28 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/09 20:55:28 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636487728747, maxDate=1637092528747, sequenceNumber=7704, masterKeyId=85 on ha-hdfs:efrei
21/11/09 20:55:28 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636487728747, maxDate=1637092528747, sequenceNumber=7704, masterKeyId=85)
21/11/09 20:55:28 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
21/11/09 20:55:28 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/julie.ngan/.staging/job_1630864376208_5122
21/11/09 20:55:30 INFO input.FileInputFormat: Total input files to process : 1
21/11/09 20:55:30 INFO mapreduce.JobSubmitter: number of splits:1
21/11/09 20:55:30 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1630864376208_5122
21/11/09 20:55:30 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636487728747, maxDate=1637092528747, sequenceNumber=7704, masterKeyId=85)]
21/11/09 20:55:30 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.0.3.0-223/0/resource-types.xml
21/11/09 20:55:30 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
21/11/09 20:55:30 INFO impl.YarnClientImpl: Submitted application application_1630864376208_5122
21/11/09 20:55:31 INFO mapreduce.Job: The url to track the job: https://hadoop-master02.efrei.online:8090/proxy/application_1630864376208_5122/
21/11/09 20:55:31 INFO mapreduce.Job: Running job: job_1630864376208_5122
21/11/09 20:55:41 INFO mapreduce.Job: Job job_1630864376208_5122 running in uber mode : false
21/11/09 20:55:41 INFO mapreduce.Job:  map 0% reduce 0%
21/11/09 20:55:50 INFO mapreduce.Job:  map 100% reduce 0%
21/11/09 20:55:55 INFO mapreduce.Job:  map 100% reduce 100%
21/11/09 20:55:55 INFO mapreduce.Job: Job job_1630864376208_5122 completed successfully
21/11/09 20:55:55 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=539
		FILE: Number of bytes written=527753
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16783
		HDFS: Number of bytes written=390
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20478
		Total time spent by all reduces in occupied slots (ms)=10448
		Total time spent by all map tasks (ms)=6826
		Total time spent by all reduce tasks (ms)=2612
		Total vcore-milliseconds taken by all map tasks=6826
		Total vcore-milliseconds taken by all reduce tasks=2612
		Total megabyte-milliseconds taken by all map tasks=10484736
		Total megabyte-milliseconds taken by all reduce tasks=5349376
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=1223
		Map output materialized bytes=539
		Input split bytes=103
		Combine input records=97
		Combine output records=36
		Reduce input groups=36
		Reduce shuffle bytes=539
		Reduce input records=36
		Reduce output records=36
		Spilled Records=72
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=184
		CPU time spent (ms)=2500
		Physical memory (bytes) snapshot=1446887424
		Virtual memory (bytes) snapshot=7286673408
		Total committed heap usage (bytes)=1515192320
		Peak Map Physical memory (bytes)=1155088384
		Peak Map Virtual memory (bytes)=3404017664
		Peak Reduce Physical memory (bytes)=291799040
		Peak Reduce Virtual memory (bytes)=3882655744
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=390
```

```bash
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -cat kindcount5/part-r-00000
```

```bash
Acer	3
Aesculus	3
Ailanthus	1
Alnus	1
Araucaria	1
Broussonetia	1
Calocedrus	1
Catalpa	1
Cedrus	4
Celtis	1
Corylus	3
Davidia	1
Diospyros	4
Eucommia	1
Fagus	8
Fraxinus	1
Ginkgo	5
Gymnocladus	1
Juglans	1
Liriodendron	2
Maclura	1
Magnolia	1
Paulownia	1
Pinus	5
Platanus	19
Pterocarya	3
Quercus	4
Robinia	1
Sequoia	1
Sequoiadendron	5
Styphnolobium	1
Taxodium	3
Taxus	2
Tilia	1
Ulmus	1
Zelkova	4
```

### 1.8.4 Maximum height per kind of tree 
```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job highestTreeByKind trees.csv highestTreeByKind2
```

```bash
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -cat highestTreeByKind2/part-r-00000
```

```bash
Acer	16.0
Aesculus	30.0
Ailanthus	35.0
Alnus	16.0
Araucaria	9.0
Broussonetia	12.0
Calocedrus	20.0
Catalpa	15.0
Cedrus	30.0
Celtis	16.0
Corylus	20.0
Davidia	12.0
Diospyros	14.0
Eucommia	12.0
Fagus	30.0
Fraxinus	30.0
Ginkgo	33.0
Gymnocladus	10.0
Juglans	28.0
Liriodendron	35.0
Maclura	13.0
Magnolia	12.0
Paulownia	20.0
Pinus	30.0
Platanus	45.0
Pterocarya	30.0
Quercus	31.0
Robinia	11.0
Sequoia	30.0
Sequoiadendron	35.0
Styphnolobium	10.0
Taxodium	35.0
Taxus	13.0
Tilia	20.0
Ulmus	15.0
Zelkova	30.0
```

### 1.8.5 Sort the trees height from smallest to largest 
```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job sortedHeight trees.csv sortedHeight2
21/11/09 21:19:05 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/09 21:19:05 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/09 21:19:05 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636489145474, maxDate=1637093945474, sequenceNumber=7709, masterKeyId=85 on ha-hdfs:efrei
21/11/09 21:19:05 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636489145474, maxDate=1637093945474, sequenceNumber=7709, masterKeyId=85)
21/11/09 21:19:05 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
21/11/09 21:19:05 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/julie.ngan/.staging/job_1630864376208_5126
21/11/09 21:19:06 INFO input.FileInputFormat: Total input files to process : 1
21/11/09 21:19:07 INFO mapreduce.JobSubmitter: number of splits:1
21/11/09 21:19:07 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1630864376208_5126
21/11/09 21:19:07 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636489145474, maxDate=1637093945474, sequenceNumber=7709, masterKeyId=85)]
21/11/09 21:19:07 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.0.3.0-223/0/resource-types.xml
21/11/09 21:19:07 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
21/11/09 21:19:07 INFO impl.YarnClientImpl: Submitted application application_1630864376208_5126
21/11/09 21:19:07 INFO mapreduce.Job: The url to track the job: https://hadoop-master02.efrei.online:8090/proxy/application_1630864376208_5126/
21/11/09 21:19:07 INFO mapreduce.Job: Running job: job_1630864376208_5126
21/11/09 21:19:16 INFO mapreduce.Job: Job job_1630864376208_5126 running in uber mode : false
21/11/09 21:19:16 INFO mapreduce.Job:  map 0% reduce 0%
21/11/09 21:19:27 INFO mapreduce.Job:  map 100% reduce 0%
21/11/09 21:19:36 INFO mapreduce.Job:  map 100% reduce 100%
21/11/09 21:19:36 INFO mapreduce.Job: Job job_1630864376208_5126 completed successfully
21/11/09 21:19:36 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=4100
		FILE: Number of bytes written=535273
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16783
		HDFS: Number of bytes written=3994
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20775
		Total time spent by all reduces in occupied slots (ms)=26736
		Total time spent by all map tasks (ms)=6925
		Total time spent by all reduce tasks (ms)=6684
		Total vcore-milliseconds taken by all map tasks=6925
		Total vcore-milliseconds taken by all reduce tasks=6684
		Total megabyte-milliseconds taken by all map tasks=10636800
		Total megabyte-milliseconds taken by all reduce tasks=13688832
	Map-Reduce Framework
		Map input records=98
		Map output records=96
		Map output bytes=3902
		Map output materialized bytes=4100
		Input split bytes=103
		Combine input records=0
		Combine output records=0
		Reduce input groups=28
		Reduce shuffle bytes=4100
		Reduce input records=96
		Reduce output records=96
		Spilled Records=192
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=213
		CPU time spent (ms)=2690
		Physical memory (bytes) snapshot=1453654016
		Virtual memory (bytes) snapshot=7284088832
		Total committed heap usage (bytes)=1498415104
		Peak Map Physical memory (bytes)=1159409664
		Peak Map Virtual memory (bytes)=3403243520
		Peak Reduce Physical memory (bytes)=294244352
		Peak Reduce Virtual memory (bytes)=3880845312
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=3994
```

```bash
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -cat sortedHeight2/part-r-00000
3 - Fagus sylvatica (Fagaceae)	2.0
89 - Taxus baccata (Taxaceae)	5.0
62 - Cedrus atlantica (Pinaceae)	6.0
39 - Araucaria araucana (Araucariaceae)	9.0
44 - Styphnolobium japonicum (Fabaceae)	10.0
32 - Quercus suber (Fagaceae)	10.0
95 - Pinus bungeana (Pinaceae)	10.0
61 - Gymnocladus dioicus (Fabaceae)	10.0
63 - Fagus sylvatica (Fagaceae)	10.0
4 - Robinia pseudoacacia (Fabaceae)	11.0
93 - Diospyros virginiana (Ebenaceae)	12.0
66 - Magnolia grandiflora (Magnoliaceae)	12.0
50 - Zelkova carpinifolia (Ulmaceae)	12.0
7 - Eucommia ulmoides (Eucomiaceae)	12.0
48 - Acer monspessulanum (Sapindacaees)	12.0
58 - Diospyros kaki (Ebenaceae)	12.0
33 - Broussonetia papyrifera (Moraceae)	12.0
71 - Davidia involucrata (Cornaceae)	12.0
36 - Taxus baccata (Taxaceae)	13.0
6 - Maclura pomifera (Moraceae)	13.0
68 - Diospyros kaki (Ebenaceae)	14.0
96 - Pinus coulteri (Pinaceae)	14.0
94 - Diospyros virginiana (Ebenaceae)	14.0
91 - Acer opalus (Sapindaceae)	15.0
5 - Catalpa bignonioides (Bignoniaceae)	15.0
70 - Fagus sylvatica (Fagaceae)	15.0
2 - Ulmus carpinifolia (Ulmaceae)	15.0
98 - Quercus ilex (Fagaceae)	15.0
28 - Alnus glutinosa (Betulaceae)	16.0
78 - Acer cappadocicum (Sapindaceae)	16.0
75 - Zelkova carpinifolia (Ulmaceae)	16.0
16 - Celtis australis (Cannabaceae)	16.0
64 - Ginkgo biloba (Ginkgoaceae)	18.0
83 - Zelkova serrata (Ulmaceae)	18.0
23 - Aesculus hippocastanum (Sapindaceae)	18.0
60 - Fagus sylvatica (Fagaceae)	18.0
34 - Corylus colurna (Betulaceae)	20.0
51 - Platanus x acerifolia (Platanaceae)	20.0
43 - Tilia tomentosa (Malvaceae)	20.0
15 - Corylus colurna (Betulaceae)	20.0
11 - Calocedrus decurrens (Cupressaceae)	20.0
1 - Corylus colurna (Betulaceae)	20.0
8 - Platanus orientalis (Platanaceae)	20.0
20 - Fagus sylvatica (Fagaceae)	20.0
35 - Paulownia tomentosa (Paulowniaceae)	20.0
12 - Sequoiadendron giganteum (Taxodiaceae)	20.0
87 - Taxodium distichum (Taxodiaceae)	20.0
13 - Platanus orientalis (Platanaceae)	20.0
10 - Ginkgo biloba (Ginkgoaceae)	22.0
47 - Aesculus hippocastanum (Sapindaceae)	22.0
86 - Platanus orientalis (Platanaceae)	22.0
14 - Pterocarya fraxinifolia (Juglandaceae)	22.0
88 - Liriodendron tulipifera (Magnoliaceae)	22.0
18 - Fagus sylvatica (Fagaceae)	23.0
24 - Cedrus atlantica (Pinaceae)	25.0
31 - Ginkgo biloba (Ginkgoaceae)	25.0
92 - Platanus x acerifolia (Platanaceae)	25.0
49 - Platanus orientalis (Platanaceae)	25.0
97 - Pinus nigra (Pinaceae)	25.0
84 - Ginkgo biloba (Ginkgoaceae)	25.0
73 - Platanus orientalis (Platanaceae)	26.0
65 - Pterocarya fraxinifolia (Juglandaceae)	27.0
42 - Platanus orientalis (Platanaceae)	27.0
85 - Juglans nigra (Juglandaceae)	28.0
76 - Pinus nigra laricio (Pinaceae)	30.0
19 - Quercus petraea (Fagaceae)	30.0
72 - Sequoiadendron giganteum (Taxodiaceae)	30.0
54 - Pterocarya stenoptera (Juglandaceae)	30.0
29 - Zelkova carpinifolia (Ulmaceae)	30.0
27 - Sequoia sempervirens (Taxodiaceae)	30.0
25 - Fagus sylvatica (Fagaceae)	30.0
41 - Platanus x acerifolia (Platanaceae)	30.0
77 - Taxodium distichum (Taxodiaceae)	30.0
55 - Platanus x acerifolia (Platanaceae)	30.0
69 - Pinus nigra (Pinaceae)	30.0
38 - Fagus sylvatica (Fagaceae)	30.0
59 - Sequoiadendron giganteum (Taxodiaceae)	30.0
52 - Fraxinus excelsior (Oleaceae)	30.0
37 - Cedrus libanii (Pinaceae)	30.0
22 - Cedrus libanii (Pinaceae)	30.0
30 - Aesculus hippocastanum (Sapindaceae)	30.0
80 - Quercus petraea (Fagaceae)	31.0
9 - Platanus orientalis (Platanaceae)	31.0
82 - Platanus x acerifolia (Platanaceae)	32.0
46 - Ginkgo biloba (Ginkgoaceae)	33.0
45 - Platanus orientalis (Platanaceae)	34.0
56 - Taxodium distichum (Taxodiaceae)	35.0
81 - Liriodendron tulipifera (Magnoliaceae)	35.0
17 - Platanus x acerifolia (Platanaceae)	35.0
53 - Ailanthus giraldii (Simaroubaceae)	35.0
57 - Sequoiadendron giganteum (Taxodiaceae)	35.0
26 - Platanus x acerifolia (Platanaceae)	40.0
74 - Platanus x acerifolia (Platanaceae)	40.0
40 - Platanus x acerifolia (Platanaceae)	40.0
90 - Platanus x acerifolia (Platanaceae)	42.0
21 - Platanus x acerifolia (Platanaceae)	45.0
```


### 1.8.6 District containing the oldest tree
```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job districtOldestTree trees.csv districtOldestTree2
21/11/09 21:21:10 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/09 21:21:10 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/09 21:21:11 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636489271005, maxDate=1637094071005, sequenceNumber=7711, masterKeyId=85 on ha-hdfs:efrei
21/11/09 21:21:11 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636489271005, maxDate=1637094071005, sequenceNumber=7711, masterKeyId=85)
21/11/09 21:21:11 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
21/11/09 21:21:11 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/julie.ngan/.staging/job_1630864376208_5128
21/11/09 21:21:12 INFO input.FileInputFormat: Total input files to process : 1
21/11/09 21:21:12 INFO mapreduce.JobSubmitter: number of splits:1
21/11/09 21:21:12 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1630864376208_5128
21/11/09 21:21:12 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636489271005, maxDate=1637094071005, sequenceNumber=7711, masterKeyId=85)]
21/11/09 21:21:12 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.0.3.0-223/0/resource-types.xml
21/11/09 21:21:12 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
21/11/09 21:21:12 INFO impl.YarnClientImpl: Submitted application application_1630864376208_5128
21/11/09 21:21:12 INFO mapreduce.Job: The url to track the job: https://hadoop-master02.efrei.online:8090/proxy/application_1630864376208_5128/
21/11/09 21:21:12 INFO mapreduce.Job: Running job: job_1630864376208_5128
21/11/09 21:21:23 INFO mapreduce.Job: Job job_1630864376208_5128 running in uber mode : false
21/11/09 21:21:23 INFO mapreduce.Job:  map 0% reduce 0%
21/11/09 21:21:31 INFO mapreduce.Job:  map 100% reduce 0%
21/11/09 21:21:37 INFO mapreduce.Job:  map 100% reduce 100%
21/11/09 21:21:37 INFO mapreduce.Job: Job job_1630864376208_5128 completed successfully
21/11/09 21:21:37 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=1315
		FILE: Number of bytes written=529763
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16783
		HDFS: Number of bytes written=7
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=19392
		Total time spent by all reduces in occupied slots (ms)=12116
		Total time spent by all map tasks (ms)=6464
		Total time spent by all reduce tasks (ms)=3029
		Total vcore-milliseconds taken by all map tasks=6464
		Total vcore-milliseconds taken by all reduce tasks=3029
		Total megabyte-milliseconds taken by all map tasks=9928704
		Total megabyte-milliseconds taken by all reduce tasks=6203392
	Map-Reduce Framework
		Map input records=98
		Map output records=77
		Map output bytes=1155
		Map output materialized bytes=1315
		Input split bytes=103
		Combine input records=0
		Combine output records=0
		Reduce input groups=1
		Reduce shuffle bytes=1315
		Reduce input records=77
		Reduce output records=1
		Spilled Records=154
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=215
		CPU time spent (ms)=2510
		Physical memory (bytes) snapshot=1452765184
		Virtual memory (bytes) snapshot=7281790976
		Total committed heap usage (bytes)=1503657984
		Peak Map Physical memory (bytes)=1158332416
		Peak Map Virtual memory (bytes)=3401986048
		Peak Reduce Physical memory (bytes)=294432768
		Peak Reduce Virtual memory (bytes)=3879804928
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=7
```

```bash
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -cat districtOldestTree2/part-r-00000
1601	5
```


### 1.8.7 District containing the most trees : 2 MapReduce (so 2 Jobs ???) EN COURS... 

#### First MapReduce : just like the distinctDistricts mr job

```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job districtMostTrees trees.csv districtMostTrees5
21/11/09 22:11:30 INFO impl.TimelineReaderClientImpl: Initialized TimelineReader URI=https://hadoop-master03.efrei.online:8199/ws/v2/timeline/, clusterId=yarn-cluster
21/11/09 22:11:30 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.102.23:10200
21/11/09 22:11:30 INFO hdfs.DFSClient: Created token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636492290877, maxDate=1637097090877, sequenceNumber=7722, masterKeyId=85 on ha-hdfs:efrei
21/11/09 22:11:30 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636492290877, maxDate=1637097090877, sequenceNumber=7722, masterKeyId=85)
21/11/09 22:11:30 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
21/11/09 22:11:31 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/julie.ngan/.staging/job_1630864376208_5137
21/11/09 22:11:31 INFO input.FileInputFormat: Total input files to process : 1
21/11/09 22:11:31 INFO mapreduce.JobSubmitter: number of splits:1
21/11/09 22:11:32 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1630864376208_5137
21/11/09 22:11:32 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for julie.ngan: HDFS_DELEGATION_TOKEN owner=julie.ngan@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1636492290877, maxDate=1637097090877, sequenceNumber=7722, masterKeyId=85)]
21/11/09 22:11:32 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.0.3.0-223/0/resource-types.xml
21/11/09 22:11:32 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
21/11/09 22:11:32 INFO impl.YarnClientImpl: Submitted application application_1630864376208_5137
21/11/09 22:11:32 INFO mapreduce.Job: The url to track the job: https://hadoop-master02.efrei.online:8090/proxy/application_1630864376208_5137/
21/11/09 22:11:32 INFO mapreduce.Job: Running job: job_1630864376208_5137
21/11/09 22:11:43 INFO mapreduce.Job: Job job_1630864376208_5137 running in uber mode : false
21/11/09 22:11:43 INFO mapreduce.Job:  map 0% reduce 0%
21/11/09 22:11:51 INFO mapreduce.Job:  map 100% reduce 0%
21/11/09 22:12:00 INFO mapreduce.Job:  map 100% reduce 100%
21/11/09 22:12:00 INFO mapreduce.Job: Job job_1630864376208_5137 completed successfully
21/11/09 22:12:00 INFO mapreduce.Job: Counters: 54
	File System Counters
		FILE: Number of bytes read=176
		FILE: Number of bytes written=527097
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16783
		HDFS: Number of bytes written=80
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		HDFS: Number of bytes read erasure-coded=0
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=19878
		Total time spent by all reduces in occupied slots (ms)=25700
		Total time spent by all map tasks (ms)=6626
		Total time spent by all reduce tasks (ms)=6425
		Total vcore-milliseconds taken by all map tasks=6626
		Total vcore-milliseconds taken by all reduce tasks=6425
		Total megabyte-milliseconds taken by all map tasks=10177536
		Total megabyte-milliseconds taken by all reduce tasks=13158400
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=776
		Map output materialized bytes=176
		Input split bytes=103
		Combine input records=97
		Combine output records=17
		Reduce input groups=17
		Reduce shuffle bytes=176
		Reduce input records=17
		Reduce output records=17
		Spilled Records=34
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=192
		CPU time spent (ms)=2220
		Physical memory (bytes) snapshot=1453723648
		Virtual memory (bytes) snapshot=7284150272
		Total committed heap usage (bytes)=1501036544
		Peak Map Physical memory (bytes)=1160740864
		Peak Map Virtual memory (bytes)=3403567104
		Peak Reduce Physical memory (bytes)=292982784
		Peak Reduce Virtual memory (bytes)=3880583168
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=80
```

```bash
[julie.ngan@hadoop-edge01 ~]$ hdfs dfs -cat districtMostTrees5/part-r-00000 
3	1
4	1
5	2
6	1
7	3
8	5
9	1
11	1
12	29
13	2
14	3
15	1
16	36
17	1
18	1
19	6
20	3
```

#### Launch the second MapReduce taking as input (mapper) the output of the 1st MR job

```bash
[julie.ngan@hadoop-edge01 ~]$ launch_job districtMostTrees2 districtMostTrees5/part-r-00000 districtMostTreesFinal
```
