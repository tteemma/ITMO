#!/bin/bash

mkdir "lab0"
cd lab0

mkdir -p charmander1/octillery charmander1/empoleon charmander1/krabby jigglypuff0/ampharos jigglypuff0/rattata jigglypuff0/ursaring jigglypuff0/gyarados jigglypuff0/cofagrigus jigglypuff0/Stoutland tynamo2/haunter tynamo2/cleffa tynamo2/skitty tynamo2/sudowoodo tynamo2/golduck
echo -e "Тип покемона ROCK FLYING"> archeops4
echo -e "Способности Tackle Morning Sun Growth Leech Seed Helping Hand Magical Leaf Sunny Day Worry Seed Take Down Solarbeam
Lucky Chant"> cherubi3
echo -e "Способности Quick Attack Focus Energy Bite Pursuit Hyper Fang Sucker Punch Scary Face Crunch Assurance Super Fang
Double-Edge Endeavor"> raticatel
cat > beheeyem << EOF
Block Miracle Eye Psybeam Headbutt Hidden Powr Imprison Simple Beam
Zen Headbutt Psych Up Psychic Calm Mind Recovaer Guard Split Power Split Synchronoise Wonder Room
EOF
cat > poliwhirl << EOF
Тип покемона WATER
NONE
EOF

mv beheeyem charmander1
mv poliwhirl charmander1

chmod 640 archeops4
chmod 555 charmander1
cd charmander1
chmod 733 empoleon
chmod 400 beheeyem
chmod 064 poliwhirl
cd ..
chmod 611 cherubi3
chmod 311 jigglypuff0
cd jigglypuff0
chmod 524 ampharos
chmod 357 rattata
chmod 666 ursaring
chmod 570 gyarados
chmod 767 cofagrigus
chmod 733 Stoutland
cd ..
mv raticatel raticate1
chmod 404 raticate1
chmod 571 tynamo2
cd tynamo2
chmod 513 haunter
chmod 573 cleffa
chmod 676 skitty
chmod 357 sudowoodo
chmod 555 golduck
cd ..

#1
chmod u+rwx charmander1
cp archeops4 charmander1/beheeyemarcheops
chmod 555 charmander1
#2
chmod u+rwx charmander1
ln archeops4 charmander1/poliwhirlarcheops
#3
#cd charmander1
#ln -s archeops4 poliwhirlarcheops
#cd ..
#hmod 555 charmander1
#4
ln -s jigglypuff0/ Copy_90
#5
cd charmander1
chmod u+wrx poliwhirl
chmod u+rwx beheeyem
cd ..
cat charmander1/poliwhirl charmander1/beheeyem > raticate1_66
chmod 064 charmander1/poliwhirl
chmod 400 charmander1/beheeyem
#6
chmod -R u+rwx jigglypuff0
chmod -R u+rwx tynamo2
cp -r tynamo2 jigglypuff0/Stoutland
#7
chmod u+rwx archeops4
chmod u+rwx tynamo2/skitty
cp archeops4 tynamo2/skitty
chmod 640 archeops4
chmod 676 tynamo2/skitty

#1
mkdir "tmp"
cd tmp
echo > tmpSave
cd ..
wc -l **/*1 > tmp/tmpSave
#2
ls -ltR **/g*
#3
cd charmander1
chmod u+rwx poliwhirl
cat beheeyem poliwhirl 2>&1 | grep -vi "m$"
chmod 064 poliwhirl
cd ..
#4
ls -ltR 2>/dev/null | grep "do" | head -n 2
#5
chmod u+rwx jigglypuff0
ls jigglypuff0 | sort
chmod 311  jigglypuff0
#6
ls -ltR jigglypuff0