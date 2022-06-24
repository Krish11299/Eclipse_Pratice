package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Gift;
import exception.ResourceNotFoundException;
import repository.GiftRepository;

@RestController
@RequestMapping("/api")
public class GiftController {

	@Autowired GiftRepository giftRepository;
	
	@GetMapping("/gift")
	public List<Gift> getAllGifts(){
		return giftRepository.findAll();
	}
	@PostMapping("/gift")
	public Gift createGifts(@RequestBody Gift gift) {
		return giftRepository.save(gift);
	}
	@GetMapping("/gift/{giftId}")
	public ResponseEntity<Gift> getGiftById(@PathVariable(value = "giftId") Long giftId)
	throws ResourceNotFoundException{
		Gift gift=giftRepository.findById(giftId).orElseThrow(()->new ResourceNotFoundException("Gift is not Found"));
		return ResponseEntity.ok(gift);
	}
	@PutMapping("/gift/{giftId}")
	public ResponseEntity<Gift> updateGift(@PathVariable(value = "GiftId") Long giftId,@RequestBody Gift giftDetails) throws ResourceNotFoundException{
		Gift gift=giftRepository.findById(giftId).orElseThrow(()->new ResourceNotFoundException("Gift is not Found"));
		gift.setGiftId(giftDetails.getGiftId());
		gift.setGiftName(giftDetails.getGiftName());
		gift.setGiftImageUrl(giftDetails.getGiftImageUrl());
		gift.setGiftPrice(giftDetails.getGiftPrice());
		gift.setGiftId(giftDetails.getGiftId());
		final Gift updatedGift=giftRepository.save(gift);
		return ResponseEntity.ok(updatedGift);
	}
	@DeleteMapping("/gift/{giftId}")
	public Map<String,Boolean> deleteGift(@PathVariable(value = "giftId")Long giftId) throws ResourceNotFoundException{
		Gift gift=giftRepository.findById(giftId).orElseThrow(()->new ResourceNotFoundException("Gift is not Found"));
		giftRepository.delete(gift);
		
		Map<String, Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
		
	}
	
}
