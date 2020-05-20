package com.wordMatcher;

import com.wordMatcher.objects.SearchCollection;
import com.wordMatcher.objects.SearchItem;

public class Main {
    private static SearchCollection items = new SearchCollection();
    public static void main(String[] args) {
    String input = "ALL";

    addAllTheItems(input);
    items.score();
    System.out.println(items);
    }
    private static void addAllTheItems(String term)
    {

        items.add(new SearchItem(term,"Auto Insurance Discounts","auto, car, car, truck, vehicle, automobile, insurance, insured, van, sedan, sports, convertible, getting discount, discounts, bundle, bundles, discounted, bundled, getting, save, savings, towing, windshield, accident"));
        items.add(new SearchItem(term,"Auto Insurance Bundling","auto, car, truck, vehicle, automobile, insurance, insured, van, sedan, sports, convertible, getting discount, discounts, bundle, bundles, discounted, bundled, getting, save, savings, towing, windshield, accident"));
        items.add(new SearchItem(term,"Auto Insurance","auto, car, car, car, car, car, car, truck, vehicle, automobile, insurance, insured, van, sedan, sports, convertible, getting, towing, windshield, accident, motor, club, motor, club, roadside"));
        items.add(new SearchItem(term,"Quick Auto ID Card","digital, ID, cards, print, login, account, credentials, ID, username, password, forgot, forget, reset, my, create, registration, register, policies, details, my, creating, policy, access, card, pay, bills, online, number, insurance, logging, number, download, auto, truck, vehicle, automobile, insurance, insured, van, sedan, sports, convertible, getting, towing, windshield, accident"));
        items.add(new SearchItem(term,"Drivewise","Drivewise, eSmart, discounts, ePolicy, auto, insurance, save, savings, teen, drivers, earn, students, rewards, defensive, driving, programs, car, car, car, car, car, environment, paperless, online, store, policy, accident, forgiveness, motor, club"));

        items.add(new SearchItem(term,"Safe Driver","Safe, drivers, saftey, rewards, driving, bonus, safely, deductible, accident, discounts, insurance, forgiveness, motor, club, car, car, car, car"));
        items.add(new SearchItem(term,"Change of Address Form","change, address, update, updating, my, account, login, documents, forms, paperwork, papers, print, manage, settings"));
        items.add(new SearchItem(term,"Epolicy","ePolicy, eSmart, insurance, environment, paperless, online, store, policy, policy, documents, digitally, access, archived, policies, information, paperwork, papers, hardcopy, documents, email, alerts, records, files, my"));
        items.add(new SearchItem(term,"Proof of Insurance","digital, ID, ID, ID, ID, card, cards, print, login, account, credentials, username, password, forgot, forget, reset, my, create, registration, register, policy, policies, details, my, creating, policy, access, pay, bills, online, number, insurance, logging, number, download"));
        items.add(new SearchItem(term,"Documents and Forms","documents, document, form, forms, policy, paperwork, papers, declarations, downloads"));
        items.add(new SearchItem(term,"File a Claim","claims, claim, files, file, filing, insurance, start, track, tracking, number, policy, policies, policy, details, my, create, creating, access, coverage, limits, deductibles, number, insurance"));
        items.add(new SearchItem(term,"Home Insurance","home, house, insurance, residential, residence, residential, insured, getting "));
        items.add(new SearchItem(term,"Landlord Toolkit","landlords, toolkits, forms, documents, form, policy, policies, paperwork, papers, rent, rental, application, lease, agreement, check, in, out, communications, log, maintenance, request, security, deposit, deposits, receipt, view, downloads, print"));
        items.add(new SearchItem(term,"Policy details via My Account","policy, policies, details, my, account, register, registration, create, creating, policy, access, ID, card, pay, bills, online, changes, coverage, limits, deductibles, file, track, claims, tips, tools, number, start"));
        items.add(new SearchItem(term,"Home Insurance Discounts","home, house, insurance, residential, residence, getting discount, discounts, bundle, bundles"));
        items.add(new SearchItem(term,"Flood Insurance","flood, flooding, floods, insurance, flooded, basement, water, damage, rain, hurricane, storm, home, getting"));
        items.add(new SearchItem(term,"Account Login","login, logging, account, credentials, ID, username, password, forgot, forget, reset, my, create, registration, register, policy, details, my, creating, policy, access, card, pay, bills, online, changes, coverage, limits, deductibles, file, filing, tracking, claims, tips, tools, number, start, insurance, manage, settings"));
        items.add(new SearchItem(term,"Digital ID Cards info","digital, ID, ID, ID, card, cards, print, login, account, credentials, username, password, forgot, forget, reset, my, create, registration, register, policy, policies, details, my, creating, policy, access, pay, bills, online, number, insurance, logging, number, download"));
        items.add(new SearchItem(term,"Mobile Access for ID Cards","mobile, digital, ID, ID, cards, print, login, account, credentials, username, password, forgot, forget, reset, my, create, registration, register, policies, details, my, creating, policy, access, card, pay, bills, online, number, insurance, logging, number, download"));
        items.add(new SearchItem(term,"My Account","login, logging, account, credentials, ID, ID, username, password, forgot, forget, reset, my, create, registration, register, policy, details, my, creating, policies, access, card, pay, bills, online, changes, coverage, limits, deductibles, file, filing, tracking, claims, tips, tools, number, start, insurance, manage, settings"));
        items.add(new SearchItem(term,"How to read an auto Declaration page","auto, auto, car, car, car, truck, vehicle, automobile, insurance, insured, van, sedan, sports, convertible, getting, read, how, insurance, declaration, declarations, page, policy, coverage, limits"));
        items.add(new SearchItem(term,"Esmart","eSmart, discounts, ePolicy, auto, insurance, save, savings, teen, drivers, earn, students, rewards, defensive, driving, programs, car, environment, paperless, online, store, policy, documents, digitally, access, archived, policies, information, paperwork, papers, hardcopy, documents, email, alerts, records, files, my, digital, digital"));
        items.add(new SearchItem(term,"Payment and billing options","payment, billing, online, options, access, account, paperless, manage, eBill, paper, enroll, now, epayments, credit, card, debit, direct, bank, withdrawl, automatic, ePolicy, quick, pay, bills"));
        items.add(new SearchItem(term,"Digital Locker","digital, digital, digital, locker, home, house, insurance, residential, residence, residential, insured, getting, inventory, app, application, stuff, track, tracking, belongings"));
    }
}
