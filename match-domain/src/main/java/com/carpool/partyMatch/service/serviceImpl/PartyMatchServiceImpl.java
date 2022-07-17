package com.carpool.partyMatch.service.serviceImpl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.carpool.partyMatch.repository.MemberRepository;


@Service
@RequiredArgsConstructor
public class PartyMatchServiceImpl implements MemberService {

  private final PartyMatchRepository partyMatchRepository;
 // private final RestTemplate restTemplate;

}
