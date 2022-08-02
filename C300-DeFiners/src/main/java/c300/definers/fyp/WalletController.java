package c300.definers.fyp;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WalletController {

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private MemberRepository memberRepository;

	// view token
	@GetMapping("/wallet")
	public String wallet(Model model, Principal principal) {

		// Get currently logged in user
		MemberDetails loggedInMember = (MemberDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		int loggedInMemberId = loggedInMember.getMember().getId();

		List<Wallet> listWallet = walletRepository.findByMemberId(loggedInMemberId);

		model.addAttribute("listWallet", listWallet);

		model.addAttribute("memberId", loggedInMemberId);

		return "view_wallet";
	}


}