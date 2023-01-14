package com.example.dobyvatel

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.dobyvatel.databinding.ActivityDecisionPageBinding
import com.example.dobyvatel.objects.MilkyWayPlanets
import kotlin.random.Random


class DecisionPage : AppCompatActivity() {

    private lateinit var binding: ActivityDecisionPageBinding

    var howManyTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecisionPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageSlider = binding.imageSlider
        val imageList = ArrayList<SlideModel>()

        //tlacitka nebudu enable dokym si uzivatel neprecita vsetko
        binding.fight.isEnabled = false
        binding.fight.setBackgroundColor(Color.GRAY)
        binding.peace.isEnabled = false
        binding.peace.setBackgroundColor(Color.GRAY)

        binding.question1.text = "Profil"
        binding.question2.text = "Dráha"
        binding.question3.text = "Atmosfera"

        // nastavy sa text a hlavny obrazok podla toho, co sa hra
        if (MilkyWayPlanets.sunIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/52DwRgn/slnkoblizko.jpg","Slnečné erupcie"))
            imageList.add(SlideModel("https://i.ibb.co/BrDtv21/slnecna-korona.jpg","Koronu možno vidieť pri zatmení Slnka"))
            imageList.add(SlideModel("https://i.ibb.co/0CgP6FK/slnecne-skvrny.jpg","Slnečné škvrny"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Slnko je najžiarivejšia hviezda, ktorú môžeš vidieť na oblohe. Je stredom slnečnej sústavy" +
                    " a okolo slnka obieha 8 planét. Jeho energia je nevyhnutná pre život na Zemi. \n"
            binding.question2.text = "Povrch"
        } else if (MilkyWayPlanets.mercuryIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/bB64gtk/povrch-merkuru.jpg","Povrch Merkúra"))
            imageList.add(SlideModel("https://i.ibb.co/xzLXXmQ/obezna-draha.jpg","Obežná dráha"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Merkúr je druhá najmenšia planéta slnešnej sústavy, najbližšia pri Slnku a " +
                    "najbohatšia na železo. Podmienky na jeho povrchu sú mimoriadne drsné. Nemá takmer žiadnu ochrannú atmosféru" +
                    "a počas dňa teploty stúpajú na neskutočných 430 C, kým v noci padajú na mrazivých -180 C. \n"

        } else if (MilkyWayPlanets.venusIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/hVwCrVW/venusapovrh.jpg","Povrch Venuše"))
            imageList.add(SlideModel("https://i.ibb.co/SvdhFCX/19-SCI-OUTTHERE-VENUS1-video-Sixteen-By-Nine3000.jpg","Venusa zabalena v hustej vrstve toxických mrakov"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Venuša je druhá planéta od Slnka a najbližší vnútorný sused Zeme." +
                    "Tieto dve planéty sú takmer identické veľkosťou a zložením, ale zároveň sú to veľmi " +
                    "rozdielne svety. Venušu stále zahaľuje súvislá vrstva hustých mrakov, pod ktorými leží šerý, mŕtvý" +
                    ", suchý svet so spáleným povrchom, horúcejším ako na hociktorej inej planéte slnečnej sústavy."

        } else if (MilkyWayPlanets.earthIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/wC3m3n1/magneticke-pole.jpg","Magnetické pole"))
            imageList.add(SlideModel("https://i.ibb.co/qYTTRc7/detailnezem.jpg","Detail Zeme"))
            imageList.add(SlideModel("https://i.ibb.co/gjwJ1Y7/atmosfera.jpg","Atmosféra"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Zem je tretia najbližšia planéta k Slnku. Ako najväčšia zo štyroch pevných" +
                    " planét vznikla približne pred 4,56 miliardy rokov. Vnútornou stavbou je Zem podobná vnútram svojich" +
                    " susedov, no v slnešnej sústave je jedničné tým, že na povrchu má dostatok kvapalnej vodz, že má atmosféru bohatú na kyslík " +
                    "a že umožňuje život."
            binding.question2.text = "Magnetické pole"

        } else if (MilkyWayPlanets.marsIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/F4ZRQ7W/mars.jpg","Mars"))
            imageList.add(SlideModel("https://i.ibb.co/pKBSRjm/marsrover.jpg","Rover"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Mars opis"

        } else if (MilkyWayPlanets.jupiterIsPlaying) {

            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/fqGNmPX/jupiterzblizka.jpg","Jupiter zblizka"))
            imageList.add(SlideModel("https://i.ibb.co/QKLNtH9/jupiter.jpg","Jupiter"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Jupiter opis"

        } else if (MilkyWayPlanets.saturnIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/cbgXJmK/saturn.jpg","Saturn"))
            imageList.add(SlideModel("https://i.ibb.co/bdf82LL/saturnvortex.jpg","Saturn"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Saturn opis"

        } else if (MilkyWayPlanets.uranusIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/drm6CRd/uranus.jpg","Uran"))
            imageList.add(SlideModel("https://i.ibb.co/1TNfRBt/uranusfalsecolor.jpg","Uran"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Uran opis"

        } else if (MilkyWayPlanets.neptuneIsPlaying) {
            imageList.clear()
            imageList.add(SlideModel("https://i.ibb.co/LzjM54b/neptuneclouds.jpg","Neptun"))
            imageList.add(SlideModel("https://i.ibb.co/LJSn02y/neptunevertical.jpg","Neptun"))
            imageSlider.setImageList(imageList,ScaleTypes.CENTER_CROP)
            binding.textAboutPlanet.text = "Neptune opis"
        }



        ///LISTENERS
        binding.fight.setOnClickListener {
            //TODO presmerovanie na imageGame stranku
            // algoritmus -> ci sa akceptuje boj alebo nie
            // prepocitavanie -> zmizne druhy button -> zmizne text -> odpocitavanie, potom sa objavi vysledok
            // a bude presmerovany na stranku ktora zvitazi
            // mozno nejaka statistika, ze kolko krat si vybral hrac boj a mier
            // vyhodnocovanie -> vypnut scrollview, zmena textu atd

            binding.scrollPlanet.visibility = View.GONE
            binding.textAboutPlanet.visibility = View.GONE
            binding.peace.visibility = View.GONE
            binding.fight.visibility = View.GONE

            binding.progressDecision.visibility = View.VISIBLE

            //najprv je loading a potom je vypisana decission
            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressDecision.visibility = View.GONE
                acceptedOrNot(1)
            }, 5000)
        }

        binding.peace.setOnClickListener {
            //TODO mierova dohoda?? kam to bude
            // detto algoritmus ci sa rozhodnu to schvalit
            binding.scrollPlanet.visibility = View.GONE
            binding.textAboutPlanet.visibility = View.GONE
            binding.peace.visibility = View.GONE
            binding.fight.visibility = View.GONE

            binding.progressDecision.visibility = View.VISIBLE

            //najprv je loading a potom je vypisana decission
            Handler(Looper.getMainLooper()).postDelayed({
                binding.progressDecision.visibility = View.GONE
                acceptedOrNot(0)
            }, 5000)
        }


        ///LISTENERS QUESTION
        binding.question1.setOnClickListener {
            howManyTimes++
            if(howManyTimes == 3){
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(1)
                binding.textAboutPlanet.text = actualText + question

            }else{

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(1)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question1.visibility = View.INVISIBLE
        }

        binding.question2.setOnClickListener {

            howManyTimes++
            if(howManyTimes == 3){
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(2)
                binding.textAboutPlanet.text = actualText + question

            }else{

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(2)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question2.visibility = View.INVISIBLE
        }

        binding.question3.setOnClickListener {
            howManyTimes++

            if(howManyTimes == 3){
                //Ak su uz vsetky otazky zodpovedane
                binding.fight.isEnabled = true
                binding.peace.isEnabled = true
                binding.fight.setBackgroundColor(resources.getColor(R.color.neon_green))
                binding.peace.setBackgroundColor(resources.getColor(R.color.neon_green))

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(3)
                binding.textAboutPlanet.text = actualText + question

            }else{

                val actualText = binding.textAboutPlanet.text.toString()
                val question = returnQuestion(3)
                binding.textAboutPlanet.text = actualText + question
            }

            //zmiznutie otazky
            binding.question3.visibility = View.INVISIBLE
        }

    }

    fun returnQuestion (numberOfQuestion:Int) :String{

//        Profil / Draha / Atmosfera
        if (MilkyWayPlanets.sunIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n Povrchová teplota Slnka dosahuje teplotu 5500 C a teplota v jadre sa môže vyštverať až na 15 miliónov stupňov. Vzdialené" +
                        "od zeme je 149,6 milióna kilometrov a svetlo zo Slnka sa dostaneme na zem za" +
                        "8 minút a 20 sekúnd.\n"
                2 -> return "\n Viditeľný povrch Slna sa volá fotosféra. Nie je to pevný povrch, ale vrstva plazmy hrubá približne 100 kilometrov," +
                        "ktorá vyzerá ako keby kypela. Taktiež môžme vidieť slnečné škrvny, čo sú chladnejšie oblasti, viditeľné ako tmavé škvrny. Na" +
                        " Slnku prebiehajú aj slnečné erupcie - nesmierne výbuchy na povrchu Slnka." +
                        "Vďaka slnečnému svetlu je možné vidieť všetky ostatné telesá v" +
                        "slnečnej sústave, pretože odrážajú slnečné svetlo alebo žiaria vďaka slnečnej energii. \n"
                3-> return "\n Fotosféra je najspodnejšia časť slnešnej atmosféry. Nad fotosférou leží hlboká pomarančovočervená chromosféra." +
                        "Koróna je najvrchnejšia časť a je možné ju vidieť počas zatmenia Slnka. Zatmenie Slnka nastáva vtedy, keď Slnko, Mesiac a Zem sú v jednej priamke.\n"
            }
        } else if (MilkyWayPlanets.mercuryIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n Povrch Merkúra je tmavý, pokrytý prachom a znetvorený dopadmi meteoritov. Nemá žiadne mesiace a dĺžka roka" +
                        "tam trvá 88 pozemských dní. \n"
                2 -> return "\n S výnímkou Pluta má Merkúr najexcentrickejšiu obežnú dráhu. To znamená že najbližší bod pri Slnku je vziadelný len" +
                        "46 miliónov kilometrov a najvzdialenejší bod je 69,8 milióna kilometrov. Os rotácie Merkúru je takmer rovná, takže z toho vypláva," +
                        "že planéta nemá ročné obdobia a že niektoré kráterz v blížkosti rovníka nikdy nezasiahne slnešné svetlo.\n"
                3-> return "\n Merkúr ma veľmi riedku a nestálu atmosféru, pretože hmotnosť tejto planéty je príliš malá na to, aby" +
                        "si atmosféru udržala. \n"
            }
        } else if (MilkyWayPlanets.venusIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n" +
                        " Povrchová teplota dosahuje 464 C. Nemá žiadne mesiace a dĺžka roka trvá 224,7 dní. " +
                        "Venuša je najjasnejšia planéta na oblohe a v jasnosti ju prekonáva len Slnko a Mesiac." +
                        "Vidieť ju možno skoro ráno (zornička) alebo na večernej oblohe (večernica)\n"
                2 -> return "\n Obežná dráha Venuše je najmenej eliptická zo všetkých planét. Je takmer presne kruhová" +
                        ". Pri obehu okolo Slnka rotuje okolo svojej osi veľmi pomaly - pomalšie než akákoľvek iná planéta - " +
                        "a navyše rotuje v opačnom smere ako väčšina ostatných planét. Jeden deň na Venuši je dlhší ako rok, avšak" +
                        "čas medzi dvoma po sebe nasledujúcimi východmi Slnka na Venuši je 117 pozemských dní. \n"
                3-> return "\n Venušina atmosféra, bohatá na oxid uhličitý, sa dvíha do výšky 80 kilometrov od povrchu. Súčasťou " +
                        "atmosféry je oblačná pokrývka s tromi odlišnými vrstvami. Najnižšia vrstva je najhustejšia a obsahuje " +
                        "veľké kvapkt kyseliny sírovej. Stredvá vrstva obsahuje menej kvapiek a v hornej vrstve sú malé kvapky. \n"
            }
        } else if (MilkyWayPlanets.earthIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n Priemerná teplota na Zemi je 15 C. Rok tu trvá 365,26 dní a okolo Zeme krúží jeden Mesiac. Ako iné planéty, " +
                        "aj Zem obieha okolo Slnka po eliptickej dráhe. V dôsledku toho jej povrch dostáva v januári o 7 percent slnečného " +
                        "žiarenia viac ako v júli. Zemská kôra a vrchná časť plášťa spoločne tvoria lifosféru. Tá je polámaná na nieľko pevných " +
                        "celkov nazývaných platne, čo plávajú na poloroztavených vrstvách plášťa pod nimi a vzájomne sa pohybujú.\n"
                2 -> return "\n Zem má silné magnetické pole, o ktorom sa predpokladá, že vzniká rotáciou vonkajšieho tekutého kovového jadra. " +
                        "Tento pohyb je hnaný kombináciou zemskej rotácie a konvektívnymi prúdmi vo vonkajšom jadre. Magnetické pole pôsobí tak, " +
                        "akoby bol vo vnútri Zeme tyčový magnet sklonený pod istým uhlom voči jej osi rotácií. Magnetické pole siaha do kozmu " +
                        "a pôsobí  ako ochranná vrstva proti vysokoráchlostnému prúdu elektrickách nabitých častíc, ktoré sa k Zemi šíria v podobe slnečného vetra. \n"
                3-> return "\n Zem je obklopená armosférou, vrstvou plynov hrubou mnoho stoviek kilomtrov. Usudzuje sa, že atmosféra vznikla čiastočne z plynov" +
                        " uvoľnených pri výbuchoch dávnych vulkánov, hoci jej kysliková zložka - taká podstatná pre väčšinu životných foriem - bola" +
                        " vytvorená hlavne rastlinami. Vplyvom gravitácie je atmosféra najhustejšia pri zemskom povrchu a s rastúcou výškou rýchlo redne. " +
                        "So stúpajúcou výškou sa mení aj teplota a klesá atmosferický tlak. Atmosféra sa skladá z: Troposféry, stratosféry, mezosféry a termosféry." +
                        "\n"
            }
        } else if (MilkyWayPlanets.marsIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.jupiterIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.saturnIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.uranusIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        } else if (MilkyWayPlanets.neptuneIsPlaying) {
            when(numberOfQuestion){
                1 -> return "\n TED: bla bla bla bla bla bla otazka1 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                2 -> return "\n TED: bla bla bla bla bla bla otazka2 \n DOMORODEC: bla bla bla bla bla odpoved \n"
                3-> return "\n TED: bla bla bla bla bla bla otazka3 \n DOMORODEC: bla bla bla bla bla odpoved \n"
            }
        }
        return ""
    }

    fun acceptedOrNot(fightOrPeace: Int) {

        val yesOrNo = next()

        ///TODO 0 je pre mier 1 je pre boj
        if (fightOrPeace == 0) {
            if (fightOrPeace == yesOrNo) {
                //TODO mimozenstania akceptovali
                // presmeruje sa na peace stranku

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "MIER sa akceptoval"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, Quizz::class.java)
                    resultLauncher.launch(intent)
                }, 5000)

            } else {
                //TODO neakceptovali, mimozenstania chcu bojovat
                //TODO mimozenstania chcu bojovat
                // presmerovanie na fight stranku
                // zmizne button peace

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "MIER SA NEAKCEPTUJE. BOJ!!!!"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, ImageGame::class.java)
                    resultLauncher.launch(intent)
                }, 5000)


            }

        } else if (fightOrPeace == 1) {
            if (fightOrPeace == yesOrNo) {
                //TODO mimozenstania chcu bojovat
                // presmerovanie na fight stranku
                // zmizne button peace

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "Boj sa akceptoval"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, ImageGame::class.java)
                    resultLauncher.launch(intent)
                }, 5000)


            } else {
                //TODO mimozenstania sa vzdavaju

                binding.decisionMade.visibility = View.VISIBLE
                binding.decisionMade.text = "NECHCEME BOJOVAT. Je to MIER!"

                Handler(Looper.getMainLooper()).postDelayed({

//                    val intent = Intent(this, ImageGame::class.java)
//                    startActivity(intent)
//                    finish()

                    val intent = Intent(this, Quizz::class.java)
                    resultLauncher.launch(intent)
                }, 5000)
            }
        }

    }



    private operator fun next(): Int {

         val random = Random

        return if (random.nextBoolean()) {
            0
        } else {
            1
        }
    }


    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes

            //aplikacia zasle data a zavrie sa... mozno nieco na statistiku??
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}