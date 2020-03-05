package UnionFind;

import java.util.*;

public class MaximumAssociationSet {
	Map<String, Integer> size;
	Map<String, String> parent;
	int maxSize = 0;
	String maxParent;
	/**
	 * @param ListA: The relation between ListB's books
	 * @param ListB: The relation between ListA's books
	 * @return: The answer
	 */
	public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
		List<String> result = new ArrayList<>();
		if (ListA.length == 0) {
			return result;
		}

		// Write your code here
		size = new HashMap<>();
		parent = new HashMap<>();

		for (int i = 0; i < ListA.length; i++) {
			size.put(ListA[i], 1);
			parent.put(ListA[i], ListA[i]);

			size.put(ListB[i], 1);
			parent.put(ListB[i], ListB[i]);
		}

		for (int i = 0; i < ListA.length; i++) {
			connect(ListA[i], ListB[i]);
		}

		Set<String> set = new HashSet<>();
		for (int i = 0; i < ListA.length; i++) {
			if (find(ListA[i]).equals(maxParent)) {
				set.add(ListA[i]);
			}
			if (find(ListB[i]).equals(maxParent)) {
				set.add(ListB[i]);
			}
		}

		result.addAll(set);

		return result;
	}

	private void connect(String a, String b) {
		String parentA = find(a);
		String parentB = find(b);
		if (!parentA.equals(parentB)) {
			parent.put(parentA, parentB);
			int currentSize = size.get(parentA) + size.get(parentB);
			if (currentSize > maxSize) {
				maxParent = parentB;
				maxSize = currentSize;
			}
			size.put(parentB, currentSize);
		}
	}

	private String find(String a) {
		String father = parent.get(a);
		while (!father.equals(parent.get(father))) {
			father = parent.get(father);
		}

		while (!a.equals(father)) {
			String temp = parent.get(a);
			parent.put(a, father);
			a = temp;
		}

		return father;
	}

	public static void main(String[] args) {
		MaximumAssociationSet mas = new MaximumAssociationSet();
		String[] input1 = {"ifiomyc","foeg","ulytw","ilshufpher","lefed","fkgfpjdg","cvbxcnw","wldarmehvi","adlbfuh","owaobztgn","iagbeobuj","kix","wsxshguyrb","gifwuxce","lahzcn","krypnpaaqa","jirc","smgec","wmdp","anbtisklcy","gczn","ziy","qzw","ffqbpvd","mjevpk","ekkp","neaeouulr","wbojjirygz","yytz","gxvxub","eyqbn","sctyd","tjko","ecr","vecmxabrgl","rlrvuzr","jzaec","aiced","ncagg","fjx","ugoy","itlk","xdx","wsxshguyrb","zdqgdgttc","oa","ejxwwefvt","ih","yzcxt","ojdjgwxeol","aszvrwoijs","omxeybs","idpb","kkrzw","ykpvevpxr","mxcpeslm","hqjdanyks","xcs","tnx","uchlahek","sopwshfjs","qdlegoe","nyqu","tdazytxd","iagbeobuj","vqxloers","shfa","gddc","cykyvnyb","iagbeobuj","fnodcy","pvizqsjms","woo","yucf","qrmpcuous","vj","djt","cztio","sd","ppfcbv","cyrguh","xsllhnygl","ni","lkuwggdc","q","msmif","snyiokpa","nvderyciwp","xshsb","uioxq","mfz","fiqqksq","bzmmnuq","xpsf","jkgmt","hlc","tq","vdonezbu","mcwchiq","pwnoic","ln","tzlawhsx","qnxaiqzp","gefpcmv","amyzzm","ztkzcy","auhg","bzmmnuq","tpzk","gdebbcfxyg","fmq","coqzeygpn","hnxztcp","sctyd","bzmmnuq","es","doq","pljvnvsy","tshefn","yotgkcew","agogvwr","mssznz","zwzv","qvnnhp","otdjznbg","gqnz","tykmtbaqu","clqsnbvjkg","ygvha","nepo","ivpaxbhom","mhctyhufz","ryuas","msphm","opfap","tkb","tr","oawnwgqbd","uflk","zlnd","oav","xcnl","vfazj","gskba","a","atjdgvn","vjwkprixtg","ivirmezgxu","fiqqksq","hrr","tsrbfu","nydzb","pdqspni","ktjnw","oe","jsjygpmxq","dcx","jotywudl","pfhr","igqzyz","akw","rrgcjv","ixz","pqcy","skfcynsocy","rnyhlayypq","gkgh","wldarmehvi","woo","kge","oplnv","djt","whkuhhplxd","hzzqtq","yaznny","yjty","dyk","eirxhcp","trv","fwseoea","utvkin","emwlcyn","uxeaihp","mvsllzx","obcq","ktal","gufcrj","mapsgmdd","gxrtyfaj","evxglpdgu","xn","sm","kszbjvevsw","tozjwyef","exgrflmpbq","mhctyhufz","pjnzel","qvnnhp","gry","rhkgklcxt","bhwuj","cfne","qymtckmjgo","icnd","suusm","mub","wp","uhblb","auhg","ks","nydzb","zco","suusm","okk","ggsrqssr","vqmzu","hsxmzoh","jmkqfu","umjyexxo","jotywudl","mxxhhj","vczw","ziqvxfkut","lgik","iiwfdvj","hsxmzoh","ezkrrbormm","ciqchan","pubfwdzv","qvduop","qs","xnzkojnl","czaswzz","nzzbk","tfzplgna","rytkj","aakenoitw","xfgldgi","pvyw","xco","oprdmjrejk","gpk","jmlhe","ngyc","svczvptu","vo","eic","zk","xfkezqkz","qysxqmxbqq","higm","kyewpxajq","iro","ttue","gcjvvzkkn","lrijiqnts","djsozykzw","xzzpxquwo","hrr","rvhjxu","fmdjo","tisl","ezaeu","qxazs","zrrqpitpi","ydblazjonx","ii","blkpharswn","rlrvuzr","hitggrvm","nnxmbnuq","mdosmgvm","uwru","ajzo","rppbdazrs","zmhovofew","pqcy","zk","schyhm","mzpjtuf","knkjixeq","kkd","sde","wmqro","yqsyyt","jwmtkvb","eseqmualrh","xqd","gorzs","ksnhsk","gyakocdnb","hyabf","cuunf","qbtliomvzu","snyiokpa","fl","uj","ys","bsrhontsvf","uoamhcadu","jvdwhxlf","xuuexjt","zgrqk","oydan","cxdwxq","tacm","effixofou","xn","ikle","ykxeepnc","sqg","gfutj","qso","zleabyig","coeshyxke","ubf","qhswzp","yo","ltaar","ixz","cfne","yziekuii","poteko","jotywudl","td","dozrxy","gbsqc","cvvp","xudcv","oxhtdf","myovaf","rmyi","opfap","fhgqgsf","clai","rsitkrkvq","inxk","ysnlxnfcd","flyqtt","pvuetjgvig","ghhnvvatqe","xzdyzn","pbdgiwc","ozznikwmq","sfeie","becdqoji","fpthnxdvy","wmsll","cvzfji","abcl","nydzb","jir","pvizqsjms","osltspfwv","bs","schyhm","jytss","tfzplgna","oufva","w","mim","ejepamly","gswlqfbcb","wvhcg","qdcakstej","tfzplgna","bxzburw","wewecsy","jnu","dqcezcx","bzmmnuq","qqihybd","ol","qllykhur","pfauiifpkd","xyduvyjs","ptjev","mbw","qubqalof","znaaaj","xqg","waepkrm","wkm","gry","qwxqh","kw","pqcy","yzcxt","dw","terw","neaeouulr","nwss","qfxmenc","aojyugmpuw","rayaokq","kd","uvdct","khteifv","gscsf","thzjovcu","tfihxm","klmvffcd","kefyuxf","cwutm","pwnoic","iagbeobuj","lgcclgvf","mwnnqljw","fuliojmze","wkxqaj","jwsr","vko","ytybc","vebmtjs","ry","qllykhur","ffevaens","hukhc","idrknqzbt","ta","c","jrhkeh","cckykbt","lho","szrtnshqgz","sx","jorft","kd","myl","nwc","vnrtm","zvejuwdpjv","jhlghecyd","fsiasgiw","kimfiuu","tjbdjlj","pvwlkax","cf","kwv","hdbpqym","ozznikwmq","cebulb","fpufwyzc","mrcdqir","udvqbjp","qixuuxqv","dobjyt","uzmmbzctz","wcdzct","pugkhymlsw","jgyxovtyo","rsdee","vypsoseixl","skvizbvwu","cltjxpk","cqxxt","yro","pfsrmzcua","cvzfji","qvtcqixuxe","jmp","ugoy","dgmklbb","gskba","nipvoyhuwx","rybbqffwku","sq","xuuexjt","dndnfwaetj","npxsts","ruus","niudhgwexa","ifqvgfzr","ozznikwmq","xyqxbdo","kwzum","cryk","fd","zyujjfbly","pdd","vauosti","jmu","hfziu","krypnpaaqa","ymvfubnl","lrshijmg","dvjwvku","asn","ppnj","esgpln","inxk","ovdn","vmkprwh","fd","il","kjeekim","wxrqhtedis","hwxrmwz","ptjev","cydznvsx","dobjyt","fkm","ofqhow","egtgbnlb","dobjyt","khrsoxvz","bpkilla","nirosrasw","fzssdas","fyifln","jtwnrxbb","bhrbgabnn","mim","nqsdsyp","ulzxzteqhm","ufptiqgpux","amfaayac","kxjqhafc","ro","cwutm","qxjtdo","antj","igxkwvgtj","ybbhllmx","xahgy","tfihxm","ae","bwmilxmlr","trtp","jmjzps","rxx","gnpourilox","zmxblo","mowosmtuk","xsf","gpdrnxr","fwaotqagi","ziy","cjubixpux","qzmz","idrknqzbt","btfkpdbep","igqzyz","aul","uzbd","hxqv","lucbjay","qdbkjbpzu","pgiqqvkja","cryk","cbiuuuch","gyztsjztmc","qysxqmxbqq","murrnlqn","fcduuxgma","citwi","ecqz","rkzhf","rnyhlayypq","doawvqsx","hoqup","dsx","fora","noqlv","wjjwmyfc","dweolaco","wh","znrw","weo","dvipkovt","dqdpnax","npnikel","rfirz","acvmhujei","mmt","vxjnncdrnu","wtxjyrregi","rorjdcv","ewx","dymtbcbge","cf","oskvr","jgpy","kg","iuofh","wpuwkogd","gdldiwdov","qnxaiqzp","cojr","ksrfbre","je","aphelrulwu","nxovoxwz","emk","uvezrad","uzqm","iyvakibqk","oes","nu","oxts","cgc","je","qcw","abcl","zxwyreeum","pembso","ildx","bljiopx","lgsvfe","qubqalof","ilrcqat","enkokafcy","aeg","nbfswbj","iqq","znrw","mqjudoo","zicslirsls","xqapxkz","tdssxsj","ioxjguivt","ofrgqzcj","oeqqpfnhfe","aw","pubfwdzv","mysgb","scymihn","wnsaoeoybp","kvohhzvo","beuyz","ftwrxtiq","afu","zjevyplgim","qtjxtuqwvd","sdfbg","zdmj","bhyppakut","wysvuycyg","tjbdjlj","afhvuqayt","hwxrmwz","knjnid","art","ouyzzxjcc","aggez","nrpkje","gb","oxts","alsjynajko","wxhy","ry","vpx","qrfzn","spsurtb","gymkhhbwi","evxglpdgu","pqwo","ldd","oeqqpfnhfe","pfnzg","lckckumbyv","liolozcb","wrjv","ia","dvtcvem","mpog","umojlqeeyc","xdzdk","ojfcrhjub","rdemc","oqnwlquz","hh","gs","yqcnvrvvm","qcit","ypszkvkrzh","jtccbshnm","ognn","lucbjay","lxpgggub","cbcz","ekkp","nihj","ktkr","crwuau","nttfnjqp","gorzs","zb","lahzcn","rlf","jca","eghwfzifi","ueqxnwwj","wdiaxi","trvnd","coeshyxke","qlr","rforsuxns","gscsf","whjsthejk","ar","fwbp","qs","klzzxwkn","xn","rkchbpe","bbd","sorkddekq","fiqqksq","lho","fdkeuwlber","sngnuavtt","bekcgehg","jofztbe","qbjdobn","yncenh","skyiceb","plzkjoxtqy","bzyq","jytss","jejmhqhcwm","ipntthunk","fapuafcwy","gxvxub","qbtliomvzu","njtl","ppkzikeh","tciz","tncarso","rayaokq","cehhdgruq","omqb","ewawomdb","rpp","mqlol","tjko","qvduop","efhfdlc","kkkqi","ys","ioduj"};
		String[] input2 = {"rriwsf","nkfbbmciw","zojig","donpfrp","ajzia","ehs","kbnkoc","drvsvft","ffevaens","cydznvsx","zrm","atjdgvn","ylb","qtixw","iiwfdvj","oydgcp","zqipo","regpqm","xumqrdye","glo","ipntthunk","idgxjnkxxv","bschuonrr","oyjhjhsax","tnetyjnq","taez","qrmpcuous","effixofou","rfirz","oawp","xpsf","rlxv","ponk","twspchem","pbrabjek","zisrpo","igsrjr","cnsgem","sopy","nu","kz","mhdxuhunnt","nlqbfdml","qxazs","jvofps","ktsrhja","hbp","mssznz","pvpaf","xdppamys","lfdm","mvyeg","ftu","rkovabqa","knjnid","vtjj","znrw","gohwv","qmo","whgthu","eywrqr","ehvdlrsos","ytwpisbu","b","vvohxjnkq","wfjw","izimafkm","yhkpavx","dvfiajnd","ziqvxfkut","icnd","ccmjuw","ptjev","vfwvmxqers","ttoymlaol","rs","enkokafcy","obzyic","jimvezm","ixzwzkjjs","ymvfubnl","gyztsjztmc","dslxqvgll","anjayvdgp","mjvbyt","dmz","wzk","lkqfayx","mgxtk","wopi","obif","xjhr","mrjcsd","pzcwjkcj","prtwip","ns","lejtkc","ysnlxnfcd","bxwpna","wxrqhtedis","rhfvogpmr","vwl","xfyiua","rh","cknvsnfork","idqnjnr","ngu","eqjlt","xgutzghqgg","jobncopu","simcssquva","zmoi","aexsgw","rwx","ihsymeju","qqt","sr","zxcvqb","jmjzps","dymtbcbge","rmmavmavgn","qfoz","gccrxefw","glil","eacysrr","enq","yclmsyp","vqha","osipvi","hszrezae","tab","zgsqw","mh","gscsf","madwhj","exsar","mim","yjty","lgik","uk","waepkrm","fcduuxgma","pzzy","ammpthqb","ekkuoi","ifzmlap","wh","tlqo","ghnstxxpkh","taez","ipubahygn","dlgeod","gei","lqwckbio","xvfybwd","hgm","wogscyojuk","gkkvkoan","cpwfdwbljm","wp","br","nyjfcqug","dijdt","hpy","sigr","bneuvs","t","sigr","bnc","axeiabo","nul","jirc","ekkuoi","asbfioqdjn","lpxtuy","nieds","sbcjrivmvd","mlr","lzxtiiunj","uuhlrd","dnfmlp","qyxnj","kz","pgofvnze","wdiaxi","jpluoclzgg","gehuxj","sqdt","afx","xhk","tie","akvpbejqbf","xtokh","lwgd","qykg","iqrwdprsy","zidai","uzqm","ngu","sbyoaf","vdiv","vxywvc","smfhbrc","zuqaudzm","eirxhcp","eocro","rtjpf","bzeskf","ncszsyhlp","lf","af","tjbdjlj","wpuwkogd","rrgcjv","iogzyijoz","xsnjltppg","xshsb","ccinfoedm","bp","eiwb","gnpourilox","znaaaj","bqpkb","za","dhed","rvhjxu","ruus","qhlgruvzxv","qsvj","cuunf","ectjyvp","rof","six","msphm","oazlauaeo","hrcdfh","zjrgeiao","krlvltwyfv","avs","trtp","hpy","yxqnp","oskvr","vmkprwh","ikle","rgpneo","rzx","bwrskcav","cqumu","lahzcn","pvpaf","oxhtdf","zpqt","ilrm","cvzfji","cbb","mht","gyfnyzz","qhlgruvzxv","cyrguh","cgvomx","yxhcgw","aojyugmpuw","iidd","mjlyixqk","sni","xyduvyjs","jqdkcnihj","ivpaxbhom","gnpourilox","agx","zsylib","zil","oeqqpfnhfe","rof","qvjw","ttsodzjce","nzaerv","fsiasgiw","gi","bm","nihj","szrtnshqgz","wousfti","wjvxgzda","vans","bxwpna","hesqsci","fbhqllofm","vdhwlrurth","bneuvs","lejtkc","ryjxhomq","zdmj","hitggrvm","mwjfn","wkxqaj","drt","pssyml","bjxdijjcjp","ewn","bhrbgabnn","tciz","ucwkid","vjlxc","nvjnyrad","kgd","uqmsafbbzf","hoqup","ozqkbi","ihsymeju","qjkahavtof","mmt","esbamd","lfvodlklb","lumcyrqf","myp","armpkhd","owa","myl","hj","dmgexoh","epikbusxp","srzh","gorzs","rybbqffwku","scqll","ccmjuw","aucvoxclff","stweslbp","ttoymlaol","upmuutqv","aqawpzyes","tydtkwt","ytxidzio","adefvubeo","ewkhawyox","vu","vghom","ikughamdd","ecqz","hlc","rwqrydrq","pwqi","tik","cvvp","fmjepu","gef","cwimrz","cbiuuuch","uysjqi","bpkilla","ihssfzp","wdwwh","trtp","igrnon","nibpe","feir","gddc","kjocmda","ofqhow","qceeeq","scg","casqbh","ujh","tjsw","iov","mk","dckdul","jjizzj","fxdomtlej","uuhlrd","mbxdavsfgi","surouwer","fcpegg","ewzdjzto","oqnxpq","jirc","qpo","flyqtt","oa","opfap","ppoga","ysnlxnfcd","syukouv","zvjfp","amlcfhz","mntnh","mb","vbavmrecdw","rbtz","xkyeolvlr","iov","vecmxabrgl","opsmy","jbxrpg","zvtjffpyo","suxbn","pyzzrywtqh","vjlxc","z","gmzjkcb","suxbn","wfgr","meolfthwa","bekcgehg","cf","nbfswbj","ufcp","bd","agx","yl","fosgxqid","oufva","kenuuhia","aqawpzyes","cuf","zfca","nualpifud","ytxidzio","hoixjehus","jmlhe","yhvy","qxjtdo","ectjyvp","xdgirsia","xez","qzcsawbbl","zzpbh","bhf","nerpu","wrlahwb","zxcvqb","vxjnncdrnu","phahf","gtbax","axlc","isvs","fwbp","obqwpwp","kwzum","ozqr","ohbg","yoxafclmt","tpwp","sbwsf","tyirp","mqhgpntzwz","wlpmj","ajzo","rtjpf","ltphskhelo","izimafkm","qn","au","uqmsrf","esorgon","pksks","azqsb","rkzhf","cwimrz","rr","sjpqikokor","rymc","dckhkf","kkwhkzqenx","ych","cnsgem","rppbdazrs","bjboxgef","cjkmnpoddu","xv","txhsoktyy","hlzjgbu","cor","ar","ptjev","bfzxxcmceb","yxr","ksnhsk","pfr","ipubahygn","wokyrfpumi","vzdjyqg","aszvrwoijs","ao","sdovglprl","yytz","ysnlxnfcd","citwi","djivzamek","lojvqpgbz","geccz","teykl","juefnstcmc","rhfvogpmr","vrxh","rzrrsxag","fora","schyhm","glo","teykl","trlxtqg","pryqqabdxk","qknxkxfy","aeodsbgzdn","rgcaq","stnlje","jvkxzmt","fuyzkggfut","tq","ol","mvxpx","jskmnt","run","bnfngfhd","xynd","zand","sorkddekq","gqllparqpu","pyvhs","umvbdoma","ssf","wewecsy","dujoiae","ezkrrbormm","ovqxyapl","wwfx","mrt","fxdomtlej","donpfrp","ydblazjonx","mdhpewxna","wmbycweyh","hdbpqym","uflk","nyqu","kxq","od","kc","nibpe","citwi","kkw","mjy","jpnymumj","irzwnqhqm","htubp","lcjrs","kg","khteifv","aphelrulwu","uarxsbuqz","nrqonla","qfamrvnfw","yjty","sx","syf","jrhkeh","wmqro","dhqcfta","xmt","igxkwvgtj","khteifv","oearn","tcvyzpaqs","necdjsm","shfa","leukh","gpk","pfsrmzcua","sxgjacnxe","zsevofpyh","poteko","mkfndkltg","rycztr","wzk","ljmwzkpo","mauzu","ii","qfoz","vdiv","inxk","qcfghah","ziy","asvqsr","uqmsafbbzf","ddaq","thzjovcu","tktuqirccv","arkhthasac","iiwfdvj","hhpldgki","qso","xsf","xappgmig","ezyhzxbo","umcf","uqmsafbbzf","igqzyz","drvsvft","xcshtnq","ews","huau","cnvoaxos","cxdwxq","gefpcmv","whuqctz","xnzkojnl","mznjurgo","ygrwklxgo","iuxgyk","uar","jht","pjshyap","rs","duzn","sbwsf","ltaar","pnruaru","elhxvs","dezu","suusm","ccinfoedm","ygzloexnp","afhvuqayt","cn","ci","wsqwsqjg","mysgb","pvkmfilm","zhghabyodv","rvvvshgkp","qzmz","myxk","gpk","gjb","wlvfklx","lntkoeuzpo","schyhm","mr","nttfnjqp","fl","odwvtizlm","uirotcizz","vbkmkph","timqm","igwu","ziy","meipllu","ubf","tgq","fsc","duzn","zqviva","wvx","skyiceb","qzmz","pouqr","rrfm","flf","cvowu","wpuwkogd","dmgexoh","ro","qwxqh","exyttd","lrvalre","uphyzo","whuqctz","ngyc","lsqbuzwkbp","ywkd","itatizee","hbedjcinh","njtl","zoukj","jhlghecyd","pyzzrywtqh","dsmsmf","tmxubxjm","cd","ymazqgxwf","wpep","pynvmos","esoadtslv","jlyyql","eiwb","cykyvnyb","oeysolkvwc","zjjofkoqp","jruvgnzai","tvpvvnw","stnlje","qn","xfyiua","wsey","cxvbrlz","cwvaffn","obwld","yjty","dvolg","rwvrzuofyr","rtupyghjp","bbjaralkt","jf","uqmsafbbzf","qt","vwm","uexwoepkut","tydtkwt","mveldsad","ywv","sttjuyjspc","xo","dawxlung","pdd","nwss","pqvz","dmz","covifoajbk","ivirmezgxu","mtxqrifc","bd","kijz","pvkmfilm","qeghsr","hht","qt","qyxnj","ecqz","ynih","umlxdsqlk","ywkd","ljzarq","c","ihvknqmzsb","ei","tpkkno","obzyic","rr","vkwyt"};
		mas.maximumAssociationSet(input1, input2);
	}
}
